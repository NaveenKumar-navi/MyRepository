package com.shoping.cart.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {

	private Long storeId;

	private String storeName;

	private List<ProductDetails> productDetails;

}
