package com.shoping.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoping.cart.bean.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
