package com.ecommerce.api.config;

import com.ecommerce.api.entity.Category;
import com.ecommerce.api.entity.Customer;
import com.ecommerce.api.entity.Product;
import com.ecommerce.api.repository.CategoryRepository;
import com.ecommerce.api.repository.CustomerRepository;
import com.ecommerce.api.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public TestConfig(CategoryRepository categoryRepository,
                      ProductRepository productRepository,
                      CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        customerRepository.deleteAll();

        Category cat1 = new Category(null, "Informática");
        Category cat2 = new Category(null, "Periféricos");
        Category cat3 = new Category(null, "Acessórios");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "Notebook Gamer", "Processador i7, 16GB RAM, RTX 4060", new BigDecimal("5500.00"), 10, cat1);
        Product p2 = new Product(null, "Teclado Mecânico RGB", "Switch Red ABNT2", new BigDecimal("250.00"), 25, cat2);
        Product p3 = new Product(null, "Mouse Sem Fio", "Sensor 16000 DPI", new BigDecimal("180.00"), 15, cat2);
        Product p4 = new Product(null, "Mousepad Speed XL", "Tecido 900x400mm", new BigDecimal("70.00"), 50, cat3);
        Product p5 = new Product(null, "Monitor 24 Pol 144Hz", "Painel IPS 1ms", new BigDecimal("950.00"), 8, cat1);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Customer c1 = new Customer(null, "Lucas Fernandes", "lucas@email.com", "12345678901", "81999998888", null);
        Customer c2 = new Customer(null, "Mariana Costa", "mariana@email.com", "98765432100", "81988887777", null);
        customerRepository.saveAll(Arrays.asList(c1, c2));

        System.out.println(">>> Base de dados populada com sucesso pelo perfil de testes! <<<");
    }
}