package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.bean.MPolWordings;



public interface MPolWordingsService {

	MPolWordings create(MPolWordings d);

	MPolWordings update(MPolWordings d);

//MPolWordings getOne(long id) ;
	List<MPolWordings> getAll();

	long getTotal();

//boolean delete(long id);
	List<MPolWordings> findByPwProductCode(String pwProductCode);

	Optional<MPolWordings> findByPwSysId(BigDecimal pwSysId);

	void saveorupdate(MPolWordings object);

	Page<MPolWordings> findAll(String code, Pageable paging);

	Page<MPolWordings> findSearch(String code, String search, Pageable paging);


}
