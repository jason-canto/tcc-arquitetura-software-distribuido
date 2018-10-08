package com.jason.ecommerce.service;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.jason.ecommerce.model.Product;

@Validated
public interface ProductService {

	@NotNull
	Iterable<Product> getAllProducts();

	Product getProduct(long id);

	Product save(Product product);
}
