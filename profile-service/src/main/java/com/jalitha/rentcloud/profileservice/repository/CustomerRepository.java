package com.jalitha.rentcloud.profileservice.repository;

import com.jalitha.rentcloud.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
