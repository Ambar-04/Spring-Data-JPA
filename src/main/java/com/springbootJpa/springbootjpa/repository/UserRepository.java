package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
