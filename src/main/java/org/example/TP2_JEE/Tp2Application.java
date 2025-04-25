package org.example.TP2_JEE;

import org.example.TP2_JEE.entities.Product;
import org.example.TP2_JEE.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp2Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product("HP Laptop", 800.0, 15));
            productRepository.save(new Product("MacBook Pro", 1200.0, 10));
            productRepository.save(new Product("Dell XPS", 1000.0, 8));

            productRepository.findAll().forEach(System.out::println);
        };
    }
}
