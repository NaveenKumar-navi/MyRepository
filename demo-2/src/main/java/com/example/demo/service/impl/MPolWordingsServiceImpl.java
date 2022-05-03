package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.MPolWordings;
import com.example.demo.repository.MPolWordingsRepository;
import com.example.demo.service.MPolWordingsService;


@Service
@Transactional
public class MPolWordingsServiceImpl implements MPolWordingsService {

	@Autowired
	private MPolWordingsRepository repository;

	private Logger log = LogManager.getLogger(MPolWordingsServiceImpl.class);

	/*
	 * public MPolWordingsServiceImpl(MPolWordingsRepository repo) { this.repository
	 * = repo; }
	 * 
	 */
	@Override
	public MPolWordings create(MPolWordings d) {

		MPolWordings entity;

		try {
			entity = repository.save(d);

		} catch (Exception ex) {
			log.error(ex);
			return null;
		}
		return entity;
	}

	@Override
	public MPolWordings update(MPolWordings d) {
		MPolWordings c;

		try {
			c = repository.saveAndFlush(d);

		} catch (Exception ex) {
			log.error(ex);
			return null;
		}
		return c;
	}

	/*
	 * @Override public MPolWordings getOne(long id) { MPolWordings t;
	 * 
	 * try { t = repository.findById(id).orElse(null);
	 * 
	 * } catch (Exception ex) { log.error(ex); return null; } return t; }
	 * 
	 */
	@Override
	public List<MPolWordings> getAll() {
		List<MPolWordings> lst;

		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error(ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public long getTotal() {
		long total;

		try {
			total = repository.count();
		} catch (Exception ex) {
			log.error(ex);
			return 0;
		}
		return total;
	}

	@Override
	public List<MPolWordings> findByPwProductCode(String pwProductCode) {

		return repository.findByPwProductCode(pwProductCode);
	}

	@Override
	public Optional<MPolWordings> findByPwSysId(BigDecimal pwSysId) {
		
		return repository.findByPwSysId(pwSysId);
	}

	@Override
	public void saveorupdate(MPolWordings object) {

		repository.saveAndFlush(object);

	}

	@Override
	public Page<MPolWordings> findAll(String code, Pageable paging) {

		return repository.findByPwProductCode(code, paging);
	}

	@Override
	public Page<MPolWordings> findSearch(String code, String search, Pageable paging) {
		// TODO Auto-generated method stub
		return null;
	}

}

