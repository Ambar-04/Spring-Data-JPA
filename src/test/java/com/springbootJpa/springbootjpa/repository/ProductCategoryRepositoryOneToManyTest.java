package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Product;
import com.springbootJpa.springbootjpa.entity.ProductCategory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryRepositoryOneToManyTest {
    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Test
    public void saveProductCategoryMethod(){
        ProductCategory productCategory = new ProductCategory();

        productCategory.setCategoryName("books");
        productCategory.setCategoryDescription("books description");

        Product product1 = new Product();
        product1.setName("Core Java");
        product1.setPrice(new BigDecimal(1000));
        product1.setDescription("core java description");
        product1.setImageUrl("image1.png");
        product1.setSku("ABCD");
        product1.setActive(true);
//        product1.setCategory(productCategory); //setting category for individual product
//        productCategory.getProductList().add(product1);

        Product product2 = new Product();
        product2.setName("Effective Java");
        product2.setPrice(new BigDecimal(2000));
        product2.setDescription("effective java description");
        product2.setImageUrl("image2.png");
        product2.setSku("ABCDE");
        product2.setActive(true);
//        product2.setCategory(productCategory); //setting category for individual product
//        productCategory.getProductList().add(product2);

        categoryRepository.save(productCategory);
    }

    @Test //fetch type lazy so only fetch the category not associated products
    void fetchProductCategory(){
        ProductCategory category = categoryRepository.findById(1L).get();
        System.out.println(category);
//        System.out.println(category.getProductList()); //org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role
    }

    @Test
    @Transactional //Here we are asking for same transaction to get associated products
    // So on demand the fetch type lazy in same transaction will load associated products
    void fetchProductCategoryAlongWithAssociatedProducts(){
        ProductCategory category = categoryRepository.findById(1L).get();
//        System.out.println(category.getProductList());
    }
}