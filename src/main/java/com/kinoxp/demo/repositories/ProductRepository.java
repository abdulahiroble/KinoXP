package com.kinoxp.demo.repositories;

import com.kinoxp.demo.model.Movie;
import com.kinoxp.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
