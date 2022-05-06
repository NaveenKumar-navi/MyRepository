package com.example.graphql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.bean.ProductType;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long>{

	@Override
	List<ProductType> findAll();
}
