package com.ecommerce.api.dto;

import com.ecommerce.api.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CustomerResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private Instant createdAt;

    public CustomerResponseDTO(Customer entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.cpf = entity.getCpf();
        this.phone = entity.getPhone();
        this.createdAt = entity.getCreatedAt();
    }
}