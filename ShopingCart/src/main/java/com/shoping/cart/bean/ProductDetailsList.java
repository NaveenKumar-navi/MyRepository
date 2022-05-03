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
@Table(name = "productDtlList")
public class ProductDetailsList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_dtl_list_id;

	@Column(name = "quantity", nullable = false)
	@Min(value = 1, message = "Quantity is required")
	private Long quantity;
	
	@Column(name = "color", nullable = false)
	@NotEmpty(message = "Color required")
	private String color;

	
	@Column(name = "size", nullable = false)
	@NotEmpty(message = "Size required")
	private String size;

	@Column(name = "sales_rate", nullable = false)
	@Min(value = 1, message = "SalesRate is required")
	private Double salesRate;

	@Column(name = "offer_rate", nullable = false)
	@Min(value = 1, message = "OfferRate is required")
	private Double offerRate;

	@Column(name = "product_id", nullable = false)
	@Min(value = 1, message = "ProductId is required")
	private Long productId;
}
