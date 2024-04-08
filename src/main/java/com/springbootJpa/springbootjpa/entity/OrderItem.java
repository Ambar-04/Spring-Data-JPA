package com.springbootJpa.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imageUrl;
    private BigDecimal price;
    private int quantity;

//    UNIDIRECTIONAL ONE2ONE
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

//    BIDIRECTIONAL ONE2MANY
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}
