package com.ecommerce.api.dto;

import com.ecommerce.api.entity.OrderItem;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderItemResponseDTO {

    private final Long productId;
    private final String productName;
    private final Integer quantity;
    private final BigDecimal price;
    private final BigDecimal subTotal;

    public OrderItemResponseDTO(OrderItem entity) {
        this.productId = entity.getProduct().getId();
        this.productName = entity.getProduct().getName();
        this.quantity = entity.getQuantity();
        this.price = entity.getPrice();
        this.subTotal = entity.getSubTotal();
    }
}