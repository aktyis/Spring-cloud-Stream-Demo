package com.example.demo.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: istyak.rana
 * @date: 18-Jun-21
 */
@RestController
public class MarketingController {


    private final StreamBridge streamBridge;

    public MarketingController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/send-message")
    public void getElement() {
        Message<String> message = MessageBuilder
                .withPayload("hello world")
                .setHeader("routingKey", "abc123")
                .build();

        streamBridge.send("email", message);
    }

}
