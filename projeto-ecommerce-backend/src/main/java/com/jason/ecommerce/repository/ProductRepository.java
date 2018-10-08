package com.jason.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.jason.ecommerce.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
