package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Role;
import com.springbootJpa.springbootjpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ManyToManyUnidirectionalTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUserMethod(){
        User user = new User();
        user.setEmail("ambar@cts.com");
        user.setFirstName("Ambar");
        user.setLastName("Adhikari");
        user.setPassword("ambar@1234");

        Role associate = new Role();
        associate.setName("Associate");

        Role analyst = new Role();
        analyst.setName("Analyst");

        user.getRoles().add(associate);
        user.getRoles().add(analyst);

        userRepository.save(user);
    }


    @Test
    void updateUser(){
        User user = userRepository.findById(1L).get();

        Role supportEng = new Role();
        supportEng.setName("Support Engineer");

        user.getRoles().add(supportEng);

        userRepository.save(user);
    }

    @Test
    void fetchUser(){
        User user = userRepository.findById(1L).get();
        System.out.println(user.getEmail());
        user.getRoles().forEach(r -> {
            System.out.println(r.getName());
        });
    }

    @Test
    void deleteUser(){
        userRepository.deleteById(1L);
    }
}
