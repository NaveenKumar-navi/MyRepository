package com.shoping.cart.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cart_id;

	@Column(name = "product_id", nullable = false)
	@Min(value = 1, message = "ProductId is required")
	private Long productId;

	@Column(name = "product_dtl_id", nullable = false)
	@Min(value = 1, message = "ProductDtlId is required")
	private Long productDtlId;

	@Column(name = "product_type_id", nullable = false)
	@Min(value = 1, message = "ProductType is required")
	private Long productTypeId;

	@Column(name = "store_id", nullable = false)
	@Min(value = 1, message = "Store id is required")
	private Long storeId;

}
