package com.zouch.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author ZouQi
 * @date 2021/9/23 下午5:26
 */
@Component
@Slf4j
public class KafkaConsumerTest {


    @KafkaListener(topics = "zouqi",groupId = "group_1")
    public void onMessage1(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        log.info("简单消费1：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }

    @KafkaListener(topics = "zouqi",groupId = "group_1")
    public void onMessage2(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        log.info("简单消费2：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }

}
