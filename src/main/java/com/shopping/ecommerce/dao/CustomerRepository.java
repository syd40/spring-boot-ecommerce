package com.shopping.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

