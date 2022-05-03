package com.shoping.cart.service;

import java.util.List;

import com.shoping.cart.bean.ProductType;

public interface ProductTypeService {

	List<ProductType> getCustomers();

	void saveProductType(ProductType request);

}
