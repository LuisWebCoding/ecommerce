package com.ecommerce.api.dto;

import com.ecommerce.api.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDTO {

    private Long id;
    private String name;

    public CategoryResponseDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}