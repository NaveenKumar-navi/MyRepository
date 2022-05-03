package com.shoping.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoping.cart.bean.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
