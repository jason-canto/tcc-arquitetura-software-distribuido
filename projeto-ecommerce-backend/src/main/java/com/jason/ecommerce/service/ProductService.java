package com.jason.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.jason.ecommerce.model.Product;
import com.jason.ecommerce.repository.ProductRepository;

@Validated
@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(long id) {
		return productRepository.findOne(id);
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}
}
