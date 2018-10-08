package com.jason.ecommerce.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.ecommerce.model.Order;
import com.jason.ecommerce.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Iterable<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order create(Order order) {
		order.setDateCreated(LocalDate.now());
		return orderRepository.save(order);
	}

	@Override
	public void update(Order order) {
		orderRepository.save(order);
	}
}
