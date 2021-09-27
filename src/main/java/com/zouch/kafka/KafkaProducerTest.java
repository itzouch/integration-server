package com.zouch.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author ZouQi
 * @date 2021/9/23 下午5:24
 */
@RestController
@RequestMapping(value = "/kafka/test")
public class KafkaProducerTest {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage) throws ExecutionException, InterruptedException {
        kafkaTemplate.send("zouqi", normalMessage);
    }

}
