package com.springbootJpa.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

//    BIDIRECTIONAL MAPPING
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "id") // referencedColumnName = "id" Primary key of Order entity
    private Order order;
}
