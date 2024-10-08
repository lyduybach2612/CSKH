package com.bach.qlkh.repository;

import com.bach.qlkh.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
