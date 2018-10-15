package com.jason.ecommerce.service;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.jason.ecommerce.model.Order;
import com.jason.ecommerce.repository.OrderRepository;

@Validated
@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Iterable<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order create(@NotNull @Valid Order order) {
		order.setDateCreated(LocalDate.now());
		return orderRepository.save(order);
	}

	public void update(@NotNull @Valid Order order) {
		orderRepository.save(order);
	}
}
