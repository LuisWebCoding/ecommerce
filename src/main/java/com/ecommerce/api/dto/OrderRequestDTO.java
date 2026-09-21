package com.ecommerce.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {

    @NotNull(message = "O id do cliente é obrigatório")
    private Long customerId;

    @NotEmpty(message = "O pedido deve conter pelo menos um item")
    @Valid
    private List<OrderItemRequestDTO> items;
}