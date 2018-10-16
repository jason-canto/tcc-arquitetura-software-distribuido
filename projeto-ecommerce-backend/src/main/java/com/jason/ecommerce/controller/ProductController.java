package com.jason.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jason.ecommerce.model.Product;
import com.jason.ecommerce.service.ProductService;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/api/products")
	public @NotNull Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(value = "/admin/products")
	public @NotNull Iterable<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping("/admin/products")
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product productReturn = productService.save(product);
		return new ResponseEntity<>(productReturn, HttpStatus.CREATED);
	}

	@PutMapping("/admin/products/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
		Product productReturn = productService.save(product);
		return new ResponseEntity<>(productReturn, HttpStatus.CREATED);
	}

	@DeleteMapping("/admin/products/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		productService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
