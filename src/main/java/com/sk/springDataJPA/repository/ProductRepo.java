package com.sk.springDataJPA.repository;

import com.sk.springDataJPA.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
