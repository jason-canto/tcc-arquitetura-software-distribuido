package com.jason.ecommerce;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jason.ecommerce.model.Product;
import com.jason.ecommerce.service.ProductService;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	private ProductService service;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@PostConstruct
	public void init() {
		service.save(new Product(1L, "Teste 1", 300.00, "http://placehold.it/200x100"));
		service.save(new Product(2L, "Teste 2", 200.00, "http://placehold.it/200x100"));
		service.save(new Product(3L, "Teste 3", 100.00, "http://placehold.it/200x100"));
		service.save(new Product(4L, "Teste 4", 5.00, "http://placehold.it/200x100"));
		service.save(new Product(5L, "Teste 5", 3.00, "http://placehold.it/200x100"));
		service.save(new Product(6L, "Lala ", 500.00, "http://placehold.it/200x100"));
		service.save(new Product(7L, "Lalala", 30.00, "http://placehold.it/200x100"));
	}

}
