package com.drzewiecki.jms.activemq.component.producer;

import com.drzewiecki.jms.activemq.component.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageSender {

    private final Producer producer;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent() {
        log.info("Starting event listener");

        var order = new Order();
        order.setOrderNumber("2");
        order.setProductId("230");
        producer.sendOrderMessage(order);

        String jsonOrder = """
                {
                    "orderNumber": "1",
                    "productId": "100"
                }
                """;
        producer.sendMessage(jsonOrder);
    }
}
