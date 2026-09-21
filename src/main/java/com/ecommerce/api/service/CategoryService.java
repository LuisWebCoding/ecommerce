package com.ecommerce.api.service;

import com.ecommerce.api.dto.CategoryRequestDTO;
import com.ecommerce.api.dto.CategoryResponseDTO;
import com.ecommerce.api.entity.Category;
import com.ecommerce.api.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Injeção de dependência via construtor (recomendada pelo Spring)
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + id));
        return new CategoryResponseDTO(category);
    }

    @Transactional
    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        // Regra de negócio: não permitir categorias com o mesmo nome
        if (categoryRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new RuntimeException("Já existe uma categoria cadastrada com o nome: " + dto.getName());
        }

        Category category = new Category();
        category.setName(dto.getName());
        category = categoryRepository.save(category);

        return new CategoryResponseDTO(category);
    }

    @Transactional
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada para exclusão.");
        }
        categoryRepository.deleteById(id);
    }
}