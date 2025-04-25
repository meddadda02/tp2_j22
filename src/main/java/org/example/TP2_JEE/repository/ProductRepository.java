package org.example.TP2_JEE.repository;

import org.example.TP2_JEE.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContains(String mc);
}