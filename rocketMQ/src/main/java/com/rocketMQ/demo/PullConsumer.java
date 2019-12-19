package com.rocketMQ.demo;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.consumer.PullStatus;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author chaoshuai.li
 * @date 2019/9/19
 * @description
 */
public class PullConsumer {

    private static final Map<MessageQueue, Long> offsetTable = new HashMap<>();

    public static void main(String[] args) throws MQClientException, InterruptedException, RemotingException, MQBrokerException {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("charlesLi-test");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.setInstanceName("testRocketMQ-consumer");

        consumer.start();

        Set<MessageQueue> messageQueues = consumer.fetchSubscribeMessageQueues("testRocketMQ");
        for (MessageQueue queue : messageQueues) {
            System.out.println("Consume from the queue: " + queue.getQueueId());
            //	long offset = consumer.fetchConsumeOffset(mq, true);
            //	PullResultExt pullResult =(PullResultExt)consumer.pull(mq, null, getMessageQueueOffset(mq), 32);
            //消息未到达默认是阻塞10秒，private long consumerPullTimeoutMillis = 1000 * 10;
            PullResult result = consumer.pullBlockIfNotFound(queue, "tagA",
                    getMessageQueueOffset(queue), 1);
            putMessageQueueOffset(queue, result.getNextBeginOffset());
            PullStatus pullStatus = result.getPullStatus();
            switch (pullStatus) {
                case FOUND:
                    List<MessageExt> messageExtList = result.getMsgFoundList();
                    for (MessageExt messageExt : messageExtList) {
                        System.out.println(new String(messageExt.getBody()));
                        Thread.sleep(5000);
                        System.out.println("current " + messageExt.getMsgId() + " is consumed");
                    }
                    break;
                case NO_NEW_MSG:
                    break;
                case NO_MATCHED_MSG:
                    break;
                case OFFSET_ILLEGAL:
                    break;
                default:
                    break;
            }
        }

        System.out.println("consumer start to shutdown");
        Thread.sleep(7000);
        consumer.shutdown();
        System.out.println("consumer shutdown over");
        System.exit(0);
    }

    private static void putMessageQueueOffset(MessageQueue messageQueue, long offset) {
        offsetTable.put(messageQueue, offset);
    }

    private static long getMessageQueueOffset(MessageQueue queue) {
        Long offset = offsetTable.get(queue);
        return Objects.isNull(offset) ? 0 : offset;

    }
}
