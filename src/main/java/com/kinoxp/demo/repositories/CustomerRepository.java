package com.kinoxp.demo.repositories;

import com.kinoxp.demo.model.Customer;
import com.kinoxp.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}
