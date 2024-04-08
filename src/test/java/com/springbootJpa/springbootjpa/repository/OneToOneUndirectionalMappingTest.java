package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Address;
import com.springbootJpa.springbootjpa.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUndirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("1000ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Pune");
        address.setStreet("Kothrud");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setZipCode("411047");

        order.setBillingAddress(address);

        orderRepository.save(order);

    }

    @Test
    void getOrderMethod(){  //get the order as well as associated address of it
        Order order = orderRepository.findById(1L).get();
    }

    @Test
    void updateOrderMethod(){
        Order order = orderRepository.findById(1L).get();

        order.setStatus("DELIVERED");
        order.getBillingAddress().setZipCode("700157");

        orderRepository.save(order);

    }

    @Test
    void deleteOrderMethod(){
        orderRepository.deleteById(1L);
    }

}
