package com.example.graphql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.bean.Store;


@Repository
public interface StoreRepository extends CrudRepository<Store,Long>{

	@Override
	List<Store> findAll();
	
	List<Store> findByStoreName(String storeName);

}
