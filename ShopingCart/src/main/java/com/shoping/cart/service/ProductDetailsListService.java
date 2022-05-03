package com.shoping.cart.service;

import java.util.List;

import com.shoping.cart.bean.ProductDetailsList;

public interface ProductDetailsListService {

	List<ProductDetailsList> getDetails();

	void saveProductDetails(ProductDetailsList request);

}
