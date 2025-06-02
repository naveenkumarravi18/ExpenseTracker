package com.example1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example1.demo.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
