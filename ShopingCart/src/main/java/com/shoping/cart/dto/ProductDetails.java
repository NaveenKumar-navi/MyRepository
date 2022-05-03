package com.shoping.cart.dto;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class ProductDetails {
	
	private Long productDetailId;
	
	private Long cartid;
	
	private Long productId;

	private String productName;
	
	private Long quantity;
	
	private String color;
	
	private String size;
	
	private Double salesRate;
	
	private Double offerRate;

}
