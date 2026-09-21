package com.ecommerce.api.service;

import com.ecommerce.api.dto.CustomerRequestDTO;
import com.ecommerce.api.dto.CustomerResponseDTO;
import com.ecommerce.api.entity.Customer;
import com.ecommerce.api.exception.BusinessException;
import com.ecommerce.api.exception.ResourceNotFoundException;
import com.ecommerce.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public List<CustomerResponseDTO> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public CustomerResponseDTO findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));
        return new CustomerResponseDTO(customer);
    }

    @Transactional
    public CustomerResponseDTO create(CustomerRequestDTO dto) {
        if (customerRepository.existsByEmailIgnoreCase(dto.getEmail())) {
            throw new BusinessException("Já existe um cliente cadastrado com o e-mail: " + dto.getEmail());
        }

        if (customerRepository.existsByCpf(dto.getCpf())) {
            throw new BusinessException("Já existe um cliente cadastrado com o CPF informado.");
        }

        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setCpf(dto.getCpf());
        customer.setPhone(dto.getPhone());

        customer = customerRepository.save(customer);
        return new CustomerResponseDTO(customer);
    }

    @Transactional
    public void delete(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado para exclusão com id: " + id);
        }
        customerRepository.deleteById(id);
    }
}