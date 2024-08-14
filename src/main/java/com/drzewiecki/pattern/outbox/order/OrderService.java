package com.drzewiecki.pattern.outbox.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.objectMapper = new ObjectMapper();
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @SneakyThrows
    public void createOrder(OrderType orderType, Object object) {
        createOrder(orderType, null, object);
    }

    @SneakyThrows
    public void createOrder(OrderType orderType, Long objectId) {
        createOrder(orderType, objectId, null);
    }

    @SneakyThrows
    public void createOrder(OrderType orderType, Long objectId, Object object) {
        var order = new Order();
        order.setType(orderType);
        order.setObject(object != null ? objectMapper.writeValueAsString(object) : null);
        order.setObjectId(objectId);
        order.setStatus(OrderStatus.NEW);
        order.setAttempts(0);
        orderRepository.save(order);
    }
}
