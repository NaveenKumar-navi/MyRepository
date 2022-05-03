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
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;

	@Column(name = "product_name", nullable = false)
	@NotEmpty(message = "ProductName required")
	private String productName;

	@Column(name = "product_description", nullable = false)
	@NotEmpty(message = "ProductDescription required")
	private String productDescription;

	@Column(name = "product_type_id", nullable = false)
	@Min(value = 1, message = "ProductTypeId is required")
	private Long productTypeId;

}
