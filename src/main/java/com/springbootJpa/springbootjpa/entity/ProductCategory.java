package com.springbootJpa.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String categoryName;
    private String categoryDescription;
//
////    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
//    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,}, fetch = FetchType.LAZY,mappedBy = "category")
//    private List<Product> productList = new ArrayList<>();
}
