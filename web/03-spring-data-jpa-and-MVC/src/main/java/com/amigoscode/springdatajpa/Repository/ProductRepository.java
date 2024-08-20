package com.amigoscode.springdatajpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigoscode.springdatajpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
