package com.main.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.nimap.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
