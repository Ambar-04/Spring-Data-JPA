package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
