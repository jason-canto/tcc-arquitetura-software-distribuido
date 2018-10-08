package com.jason.ecommerce.dto;

import com.jason.ecommerce.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDto {

	private Product product;

	private Integer quantity;

}
