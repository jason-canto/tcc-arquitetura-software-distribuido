package com.jason.ecommerce.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderProducts")
public class Order implements Serializable {

	private static final long serialVersionUID = 576741977512165463L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateCreated;

	private String status;

	@OneToMany(mappedBy = "pk.order")
	@Valid
	private List<OrderProduct> orderProducts = new ArrayList<>();

	@Transient
	public Double getTotalOrderPrice() {
		double sum = 0D;
		List<OrderProduct> orderProducts = getOrderProducts();
		for (OrderProduct op : orderProducts) {
			sum += op.getTotalPrice();
		}

		return sum;
	}

	@Transient
	public int getNumberOfProducts() {
		return this.orderProducts.size();
	}
}
