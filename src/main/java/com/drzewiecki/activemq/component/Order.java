package com.drzewiecki.activemq.component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Order {
    private String orderNumber;
    private String productId;
}
