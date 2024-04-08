package com.springbootJpa.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//@NamedQuery(
//        name = "Product.findByPrice",
//        query = "SELECT p from Product p where p.price =:price" //Named Params JPQL
//        // query = "SELECT p from Product p where p.price = ?1" //Index Params JPQL
//)

//@NamedQueries(
//        {
//                @NamedQuery(
//                        name = "Product.findAllByOrderByNameDesc",
//                        query = "SELECT p from Product p ORDER BY p.name DESC"
//                ),
//                @NamedQuery(
//                        name = "Product.findByPrice",
//                        query = "SELECT p from Product p where p.price =:price"
//                )
//        }
//)

//@NamedNativeQuery(
//        name = "Product.findByDescription",
//        query = "SELECT * from products p where p.description =:description",
//        //query = "SELECT * from products p where p.description = ?1",
//        resultClass = Product.class
//)

@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "Product.findByDescription",
                        query = "select * from products p where p.description = :description",
                        resultClass = Product.class
                ),
                @NamedNativeQuery(
                        name = "Product.findAllByOrderByNameASC",
                        query = "select * from products p ORDER BY p.name ASC",
                        resultClass = Product.class
                )
        }
)

@Table(
        name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                )
        }
)
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )

    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;

    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
//    private ProductCategory category;
}
