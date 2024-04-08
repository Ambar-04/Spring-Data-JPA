package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
