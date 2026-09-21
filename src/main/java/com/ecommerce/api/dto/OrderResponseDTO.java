package com.ecommerce.api.dto;

import com.ecommerce.api.entity.Order;
import com.ecommerce.api.entity.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
public class OrderResponseDTO {

    private final Long id;
    private final Instant moment;
    private final OrderStatus status;
    private final Long customerId;
    private final String customerName;
    private final BigDecimal total;
    private final List<OrderItemResponseDTO> items;

    public OrderResponseDTO(Order entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.status = entity.getStatus();
        this.customerId = entity.getCustomer().getId();
        this.customerName = entity.getCustomer().getName();
        this.total = entity.getTotal();
        this.items = entity.getItems().stream()
                .map(OrderItemResponseDTO::new)
                .toList();
    }
}