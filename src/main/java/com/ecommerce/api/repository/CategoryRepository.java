package com.ecommerce.api.repository;

import com.ecommerce.api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Só de herdar JpaRepository, você ganha de graça:
    // save(), findById(), findAll(), deleteById(), count(), etc.

    // Método customizado que o Spring Data implementa sozinho pelo nome:
    boolean existsByNameIgnoreCase(String name);
}