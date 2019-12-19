package com.rocketMQ.demo;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.util.Date;

/**
 * @author chaoshuai.li
 * @date 2019/9/19
 * @description
 */
public class Product {

    public static void main(String[] args) throws MQClientException, InterruptedException, RemotingException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("charlesLi-test");
        producer.setNamesrvAddr("localhost:9876");
        producer.setInstanceName("testRocketMQ-producer");
        producer.start();
        int i = 0;
        while (true) {
            Thread.sleep(1000);
            String body = (new Date() + " Hello RocketMQ ,QuickStart" + i);
            final Message message = new Message("testRocketMQ", "tagA", body.getBytes());
            System.out.println(body);
            producer.send(message, (mqs, msg, arg) -> {
                int index = msg.hashCode() % mqs.size();
                return mqs.get(index);
            }, i);
            i++;
        }
    }

}
