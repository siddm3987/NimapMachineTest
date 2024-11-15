package com.main.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.nimap.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
