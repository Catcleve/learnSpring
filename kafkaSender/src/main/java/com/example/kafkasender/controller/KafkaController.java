package com.example.kafkasender.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
public class KafkaController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public void send(String topic , String message){
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, message);
        send.addCallback(result -> log.info("发送成功，返回结果为{}",result), ex -> log.error("反馈信息失败",ex));
    }

    @GetMapping("/send/checked")
    public void sendChecked(@RequestParam(required = false,defaultValue = "default1") String topic ,
                            String message){
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, message);
        send.addCallback(result -> log.info("发送成功，返回结果为{}",result), ex -> log.error("反馈信息失败",ex));
    }

}
