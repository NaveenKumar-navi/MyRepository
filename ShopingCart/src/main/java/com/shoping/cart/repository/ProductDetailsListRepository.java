package com.shoping.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoping.cart.bean.ProductDetailsList;

public interface ProductDetailsListRepository extends JpaRepository<ProductDetailsList, Long> {

}
