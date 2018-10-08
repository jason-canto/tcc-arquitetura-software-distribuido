package com.jason.ecommerce.service;

import org.springframework.validation.annotation.Validated;

import com.jason.ecommerce.model.OrderProduct;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService {

	OrderProduct create(@NotNull @Valid OrderProduct orderProduct);
}
