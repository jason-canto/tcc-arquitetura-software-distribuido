package com.jason.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.jason.ecommerce.model.OrderProduct;
import com.jason.ecommerce.model.OrderProductPK;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
