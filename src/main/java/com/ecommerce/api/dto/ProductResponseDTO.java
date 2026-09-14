package com.ecommerce.api.dto;

import com.ecommerce.api.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private CategoryResponseDTO category;

    public ProductResponseDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.stockQuantity = entity.getStockQuantity();
        if (entity.getCategory() != null) {
            this.category = new CategoryResponseDTO(entity.getCategory());
        }
    }
}