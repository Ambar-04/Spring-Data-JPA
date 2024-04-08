package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
