package com.drzewiecki.jms.activemq.controller;

import com.drzewiecki.jms.activemq.component.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {

    private final Producer producer;

    @PostMapping
    public void sendMessage(@RequestBody Message message){
        producer.sendMessage(message.getData());
    }
}
