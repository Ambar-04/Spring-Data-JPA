package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuery(){
        Product product = productRepository.findByPrice(new BigDecimal(100));

        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void namedJPQLQueries(){
        List<Product> productList = productRepository.findAllByOrderByNameDesc();

        productList.forEach((p) -> {
                    System.out.println(p.getName());
                    System.out.println(p.getDescription());
                }
        );

        Product product = productRepository.findByPrice(new BigDecimal(200));

        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void namedNativeSQLQuery(){
        Product product = productRepository.findByDescription("product 1 description");

        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void namedNativeSQLQueries(){
        Product product = productRepository.findByDescription("product 1 description");

        System.out.println(product.getName());
        System.out.println(product.getDescription());

        List<Product> products = productRepository.findAllByOrderByNameASC();

        products.forEach((p) ->{
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }
}
