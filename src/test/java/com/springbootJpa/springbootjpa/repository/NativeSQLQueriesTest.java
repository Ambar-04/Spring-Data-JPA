package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class NativeSQLQueriesTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLIndexParam("product 1",
                "product 1 description");

        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam("product 1",
                "product 1 description");

        System.out.println(product.getId());
        System.out.println(product.getName());
    }

}
