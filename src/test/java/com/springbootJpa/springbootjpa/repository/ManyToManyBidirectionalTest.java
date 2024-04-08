package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Role;
import com.springbootJpa.springbootjpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManyToManyBidirectionalTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRoles(){

        User user1 = new User();
        user1.setEmail("ambar@cts.com");
        user1.setFirstName("Ambar");
        user1.setLastName("Adhikari");
        user1.setPassword("ambar@1234");

        User user2 = new User();
        user2.setEmail("sam@cts.com");
        user2.setFirstName("Sam");
        user2.setLastName("Ghosh");
        user2.setPassword("Sam@1234");

        Role role = new Role();
        role.setName("IPM Analyst");

        role.getUsers().add(user1);
        role.getUsers().add(user2);

        user1.getRoles().add(role);
        user2.getRoles().add(role);

        roleRepository.save(role);
    }

    @Test
    void fetchRoles(){
        List<Role> roleList = roleRepository.findAll();
        roleList.forEach((r) -> {
            System.out.println(r.getName());

            //fetching all users of that role
            r.getUsers().forEach((u) -> {
                System.out.println(u.getFirstName());
            });
        });
    }
}
