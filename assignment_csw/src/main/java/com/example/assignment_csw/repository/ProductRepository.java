package com.example.assignment_csw.repository;

import com.example.assignment_csw.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
