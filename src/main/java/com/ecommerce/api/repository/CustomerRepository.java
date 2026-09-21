package com.ecommerce.api.repository;

import com.ecommerce.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByCpf(String cpf);

    Optional<Customer> findByEmailIgnoreCase(String email);
}