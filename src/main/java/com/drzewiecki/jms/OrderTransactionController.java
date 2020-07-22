package com.drzewiecki.jms;


import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class OrderTransactionController {

    private final JmsTemplate jmsTemplate;

    @PostMapping("/send")
    public void send(@RequestBody OrderTransaction transaction) {
        System.out.println("Sending a transaction.");
        // Post message to the message queue named "OrderTransactionQueue"
        jmsTemplate.convertAndSend("OrderTransactionQueue", transaction);
    }
}