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
		service.save(new Product(1L, "Relógio Masculino", 300.00, "http://eshop.skoda-auto.com/wcsstore/B2CStore/Pictures/Katalog-galerie/TN_000050800S_1.jpg"));
		service.save(new Product(2L, "Relógio Prateado", 200.00, "http://eshop.skoda-auto.com/wcsstore/B2CStore/Pictures/Katalog-galerie/TN_000050801E041_2.jpg"));
		service.save(new Product(3L, "Relógio Esportivo", 100.00, "https://eshop.skoda-auto.sk/wcsstore/ESVKStore/Pictures/Katalog-galerie/TN_000050800R_1.jpg"));
		service.save(new Product(4L, "Relógio Masculino", 50.00, "https://i.ebayimg.com/thumbs/images/g/ZyYAAOSwSzRZOhxM/s-l200.jpg"));
		service.save(new Product(5L, "Relógio Feminino", 35.00, "http://www.discounted4you.com/resources/Kenth%20Cole%20Watch%204764.jpg"));
		service.save(new Product(6L, "Relógio Dourado ", 500.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEgLZFaIfLcw7qb0CYa5u0UWMMrLZG_K6ROKl1_XLC_Vu93u8I6g"));
		service.save(new Product(7L, "Relógio Unisex", 30.00, "http://eshop.skoda-auto.com/wcsstore/B2CStore/Pictures/Katalog-galerie/TN_3U0050800_5.jpg"));
	}

}
