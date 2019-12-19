package com.rocketMQ.demo;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * @author chaoshuai.li
 * @date 2019/9/19
 * @description
 */
public class PushConsumer {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("charlesLi-test");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.setInstanceName("testRocketMQ-consumer");
        consumer.subscribe("testRocketMQ", "tagA");

        consumer.registerMessageListener((MessageListenerOrderly) (list, consumeOrderlyContext) -> {
            for (MessageExt messageExt : list) {
                System.out.println(new String(messageExt.getBody()));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("current " + messageExt.getMsgId() + " is consumed");
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
        System.out.println("consumer start to shutdown");
        Thread.sleep(7000);
        consumer.shutdown();
        System.out.println("consumer shutdown over");
        System.exit(0);
    }

}
