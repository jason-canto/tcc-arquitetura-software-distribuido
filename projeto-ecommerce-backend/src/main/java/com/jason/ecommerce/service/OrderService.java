package com.jason.ecommerce.service;

import org.springframework.validation.annotation.Validated;

import com.jason.ecommerce.model.Order;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {

	@NotNull
	Iterable<Order> getAllOrders();

	Order create(@NotNull @Valid Order order);

	void update(@NotNull @Valid Order order);
}
