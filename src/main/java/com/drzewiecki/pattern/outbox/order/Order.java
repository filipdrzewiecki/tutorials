package com.drzewiecki.pattern.outbox.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Outbox table to save all data before it will be send to another microservice
 */
@Entity
@Getter
@Setter
public class Order {

    @Id
    private Long id;

    private OrderType type;

    private String object;

    private Long objectId;

    private OrderStatus status;

    private LocalDateTime created;

    private LocalDateTime lastTry;

    private long attempts;
}
