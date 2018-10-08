package com.jason.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.jason.ecommerce.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
