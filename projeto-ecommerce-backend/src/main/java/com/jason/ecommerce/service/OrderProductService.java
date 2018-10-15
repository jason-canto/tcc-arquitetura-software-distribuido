package com.jason.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.jason.ecommerce.model.OrderProduct;
import com.jason.ecommerce.repository.OrderProductRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@Service
@Transactional
public class OrderProductService {

	@Autowired
	private OrderProductRepository orderProductRepository;

	public OrderProduct create(@NotNull @Valid OrderProduct orderProduct) {
		return orderProductRepository.save(orderProduct);
	}
}
