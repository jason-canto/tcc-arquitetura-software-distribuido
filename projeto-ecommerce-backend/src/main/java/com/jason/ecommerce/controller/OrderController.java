package com.jason.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jason.ecommerce.dto.OrderProductDto;
import com.jason.ecommerce.exception.ResourceNotFoundException;
import com.jason.ecommerce.model.Order;
import com.jason.ecommerce.model.OrderProduct;
import com.jason.ecommerce.model.OrderStatus;
import com.jason.ecommerce.service.OrderProductService;
import com.jason.ecommerce.service.OrderService;
import com.jason.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderProductService orderProductService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @NotNull Iterable<Order> list() {
		return orderService.getAllOrders();
	}

	@PostMapping
	public ResponseEntity<Order> create(@RequestBody OrderForm form) {
		List<OrderProductDto> formDtos = form.getProductOrders();
		validateProductsExistence(formDtos);
		Order order = new Order();
		order.setStatus(OrderStatus.PAID.name());
		order = orderService.create(order);

		List<OrderProduct> orderProducts = new ArrayList<>();
		for (OrderProductDto dto : formDtos) {
			orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto.getProduct().getId()), dto.getQuantity())));
		}

		order.setOrderProducts(orderProducts);

		orderService.update(order);

		String uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/orders/{id}")
				.buildAndExpand(order.getId()).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
	}

	private void validateProductsExistence(List<OrderProductDto> orderProducts) {
		List<OrderProductDto> list = orderProducts.stream()
				.filter(op -> Objects.isNull(productService.getProduct(op.getProduct().getId())))
				.collect(Collectors.toList());

		if (!CollectionUtils.isEmpty(list)) {
			new ResourceNotFoundException("Product not found");
		}
	}

	public static class OrderForm {

		private List<OrderProductDto> productOrders;

		public List<OrderProductDto> getProductOrders() {
			return productOrders;
		}

		public void setProductOrders(List<OrderProductDto> productOrders) {
			this.productOrders = productOrders;
		}
	}
}
