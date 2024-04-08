package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Address;
import com.springbootJpa.springbootjpa.entity.Order;
import com.springbootJpa.springbootjpa.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // save order along with also save it's order items
    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setStatus("In progress");

        // create order item 1
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(1L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("image1.png");
        orderItem1.setOrder(order); //for bidirectional
        order.getOrderItems().add(orderItem1);

        // create order item 2
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(2L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.png");
        orderItem2.setOrder(order); //for bidirectional
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(order.getOrderItems().size());

        Address address = new Address();
        address.setCity("Pune");
        address.setStreet("Kothrud");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setZipCode("411047");

        address.setOrder(order);
        order.setBillingAddress(address);

        orderRepository.save(order);
    }

    @Test
    void fetchOrderMethod(){
        Order order = orderRepository.findById(1L).get();
        System.out.println(order.getStatus());

        for(OrderItem item : order.getOrderItems()){
            System.out.println(item.getProduct().getName());
        }

//        System.out.println(order.toString());  //Don't use the toString() method in BIDIRECTIONAL mappings, it will result in a stack overflow error.
//Getting a stack overflow error in a bidirectional mapping in JPA (Java Persistence API) typically happens due to a recursive call in the toString() method.
// When you have two entities with a bidirectional relationship, and each entity's toString() method calls the other's toString(), it creates an infinite recursion, resulting in a stack overflow error.
    }

    @Test
    void deleteOrderMethod(){
        orderRepository.deleteById(1L);
    }
}


