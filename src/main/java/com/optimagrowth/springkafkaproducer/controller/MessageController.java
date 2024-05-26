package com.optimagrowth.springkafkaproducer.controller;

import com.optimagrowth.springkafkaproducer.config.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/produce")
    public String publishMessage(@RequestParam("msg") String message) {
        kafkaProducer.sendMessage(message);
        return "Message published successfully";
    }
}
