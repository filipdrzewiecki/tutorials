package com.drzewiecki.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderTransactionReceiver {

    @JmsListener(destination = "OrderTransactionQueue", containerFactory = "myFactory")
    public void receiveMessage(OrderTransaction transaction) {
        System.out.println("Received <" + transaction + ">");
    }
}
