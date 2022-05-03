package com.shoping.cart.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producttype")
public class ProductType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_type_id;

	@Column(name = "product_type", nullable = false)
	@NotEmpty(message = "ProductType required")
	private String productType;

	@Column(name = "store_id", nullable = false)
	@Min(value = 1, message = "Store id is required")
	private Long storeId;

}
