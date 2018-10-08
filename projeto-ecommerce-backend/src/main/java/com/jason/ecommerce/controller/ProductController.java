package com.jason.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jason.ecommerce.model.Product;
import com.jason.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = { "", "/" })
	public @NotNull Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product productReturn = productService.save(product);
		return new ResponseEntity<>(productReturn, HttpStatus.CREATED);
	}
}
