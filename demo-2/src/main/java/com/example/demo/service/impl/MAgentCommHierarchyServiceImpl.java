
package com.example.demo.service.impl;

import java.util.ArrayList;
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

import com.example.demo.bean.MAgentCommHierarchy;
import com.example.demo.bean.MAgentCommHierarchyList;
import com.example.demo.dto.MAgentCommHierarchyListDto;
import com.example.demo.dto.MAgentCommHierarchyMultipleSaveDto;
import com.example.demo.dto.MAgentCommHierarchySubListDto;
import com.example.demo.repository.MAgentCommHierarchyRepository;
import com.example.demo.service.MAgentCommHierarchyService;



@Service
@Transactional
public class MAgentCommHierarchyServiceImpl implements MAgentCommHierarchyService {

	@Autowired
	private MAgentCommHierarchyRepository repository;

	private Logger log = LogManager.getLogger(MAgentCommHierarchyServiceImpl.class);

	@Override
	public List<MAgentCommHierarchy> getAll() {
		List<MAgentCommHierarchy> lst;

		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error(ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public Optional<MAgentCommHierarchy> findByAcmAgentCode(String agentCode) {

		return repository.findByAcmAgentCode(agentCode);
	}

	@Override
	public void saveorupdate(MAgentCommHierarchy obj) {

		repository.saveAndFlush(obj);

	}

	@Override
	public Page<MAgentCommHierarchy> findAll(Pageable paging) {

		return repository.findAll(paging);
	}

	@Override
	public Page<MAgentCommHierarchy> findSearch(String search, Pageable paging) {

		String sear = "%" + search + "%";

		return repository.findAll(sear, paging);
	}

	@Override
	public Optional<MAgentCommHierarchy> findByAcmSchFmCode(String acmSchFmCode) {

		return repository.findByAcmSchFmCode(acmSchFmCode);
	}

	@Override
	public Optional<MAgentCommHierarchy> findByAcmAgentCodeAndAcmCompCodeAndAcmProdCodeAndAcmSchFmCode(
			String acmAgentCode, String acmCompCode, String acmProdCode, String acmSchFmCode) {

		return repository.findByAcmAgentCodeAndAcmCompCodeAndAcmProdCodeAndAcmSchFmCode(acmAgentCode, acmCompCode,
				acmProdCode, acmSchFmCode);
	}

	@Override
	public void saveorupdate(MAgentCommHierarchyList object) {
		
		repository.saveAllAndFlush(object.getMAgentCommHierarchyDto());
		
	}

	@Override
	public Page<MAgentCommHierarchyListDto> findByAll(Pageable paging) {
		
		return repository.findByAll(paging);
	}

	@Override
	public List<MAgentCommHierarchyMultipleSaveDto> findByValues(Pageable paging) {
		List<MAgentCommHierarchyMultipleSaveDto> obj = new ArrayList<MAgentCommHierarchyMultipleSaveDto>();

		Page<MAgentCommHierarchyListDto> list = repository.findByAll(paging);

		for (MAgentCommHierarchyListDto data : list.getContent()) {
			MAgentCommHierarchyMultipleSaveDto dataObj = new MAgentCommHierarchyMultipleSaveDto();

			
			dataObj.setAcmCompCode(data.getAcmCompCode());
			dataObj.setAcmProdCode(data.getAcmProdCode());
			dataObj.setAcmSchFmCode(data.getAcmSchFmCode());
			dataObj.setAcmSchToCode(data.getAcmSchToCode());
			dataObj.setAcmAgentCode(data.getAcmAgentCode());
			dataObj.setAcmRmAgentCode(data.getAcmRmAgentCode());
			dataObj.setAcmLevel(data.getAcmLevel());
			dataObj.setAcmLevelDesc(data.getAcmLevelDesc());
			dataObj.setAcmPolTermFm(data.getAcmPolTermFm());
			dataObj.setAcmPolTermTo(data.getAcmPolTermTo());

			
			List<MAgentCommHierarchySubListDto> subList = new ArrayList<MAgentCommHierarchySubListDto>();

			List<MAgentCommHierarchy> dataList = repository
					.findByAcmCompCodeAndAcmProdCodeAndAcmSchFmCodeAndAcmAgentCodeAndAcmRmAgentCodeAndAcmLevelAndAcmLevelDescAndAcmPolTermFmAndAcmPolTermTo(
						 data.getAcmCompCode(), data.getAcmSchFmCode(),
							data.getAcmProdCode(),data.getAcmAgentCode(),data.getAcmRmAgentCode(),
							data.getAcmLevel(), data.getAcmLevelDesc(),data.getAcmPolTermFm(),data.getAcmPolTermTo());

			for (MAgentCommHierarchy agentData : dataList) {
				MAgentCommHierarchySubListDto subData = new MAgentCommHierarchySubListDto();

				subData.setAcmSysId(agentData.getAcmSysId());
				subData.setAcmPolYearFm(agentData.getAcmPolYearFm());
				subData.setAcmPolYearTo(agentData.getAcmPolYearTo());
				subData.setAcmCommRate(agentData.getAcmCommRate());
				subData.setAcmCommTargetRate(agentData.getAcmCommTargetRate());
				subData.setAcmEffFmDt(agentData.getAcmEffFmDt());
				subData.setAcmEffToDt(agentData.getAcmEffToDt());
				subData.setAcmStatus(agentData.getAcmStatus());
				subList.add(subData);

			}
			dataObj.setAcmSubList(subList);

			obj.add(dataObj);

		}

		return obj;
	}

	@Override
	public Page<MAgentCommHierarchyListDto> findBySearch(String search, Pageable paging) {
		
		String sear = "%" + search + "%";

		return repository.findBySearch(sear, paging);
	}

	@Override
	public List<MAgentCommHierarchyMultipleSaveDto> findBySearchValues(String search, Pageable paging) {
		
		String sear = "%" + search + "%";

		List<MAgentCommHierarchyMultipleSaveDto> obj = new ArrayList<MAgentCommHierarchyMultipleSaveDto>();

		Page<MAgentCommHierarchyListDto> list = repository.findBySearch(sear, paging);

		if (list.isEmpty()) {
			return null;
		} else {
			for (MAgentCommHierarchyListDto data : list.getContent()) {
				MAgentCommHierarchyMultipleSaveDto dataObj = new MAgentCommHierarchyMultipleSaveDto();

				dataObj.setAcmCompCode(data.getAcmCompCode());
				dataObj.setAcmProdCode(data.getAcmProdCode());
				dataObj.setAcmSchFmCode(data.getAcmSchFmCode());
				dataObj.setAcmSchToCode(data.getAcmSchToCode());
				dataObj.setAcmAgentCode(data.getAcmAgentCode());
				dataObj.setAcmRmAgentCode(data.getAcmRmAgentCode());
				dataObj.setAcmLevel(data.getAcmLevel());
				dataObj.setAcmLevelDesc(data.getAcmLevelDesc());
				dataObj.setAcmPolTermFm(data.getAcmPolTermFm());
				dataObj.setAcmPolTermTo(data.getAcmPolTermTo());
				
//				dataObj.setAcmAgentCode(data.getAcmAgentCode());
//				dataObj.setAcmCompCode(data.getAcmCompCode());
//				dataObj.setAcmSchFmCode(data.getAcmSchFmCode());
//				dataObj.setAcmSchToCode(data.getAcmSchToCode());
//				dataObj.setAcmProdCode(data.getAcmProdCode());
//				dataObj.setAcmPolicyPremFmTerm(data.getAcmPolicyPremFmTerm());
//				dataObj.setAcmPolicyPremToTerm(data.getAcmPolicyPremToTerm());

				List<MAgentCommHierarchySubListDto> subList = new ArrayList<MAgentCommHierarchySubListDto>();

				List<MAgentCommHierarchy> dataList = repository
						.findByAcmCompCodeAndAcmProdCodeAndAcmSchFmCodeAndAcmAgentCodeAndAcmRmAgentCodeAndAcmLevelAndAcmLevelDescAndAcmPolTermFmAndAcmPolTermTo(
							 data.getAcmCompCode(), data.getAcmSchFmCode(),
								data.getAcmProdCode(),data.getAcmAgentCode(),data.getAcmRmAgentCode(),
								data.getAcmLevel(), data.getAcmLevelDesc(),data.getAcmPolTermFm(),data.getAcmPolTermTo());

				for (MAgentCommHierarchy agentData : dataList) {
					MAgentCommHierarchySubListDto subData = new MAgentCommHierarchySubListDto();

					subData.setAcmSysId(agentData.getAcmSysId());
					subData.setAcmPolYearFm(agentData.getAcmPolYearFm());
					subData.setAcmPolYearTo(agentData.getAcmPolYearTo());
					subData.setAcmCommRate(agentData.getAcmCommRate());
					subData.setAcmCommTargetRate(agentData.getAcmCommTargetRate());
					subData.setAcmEffFmDt(agentData.getAcmEffFmDt());
					subData.setAcmEffToDt(agentData.getAcmEffToDt());
					subData.setAcmStatus(agentData.getAcmStatus());
					subList.add(subData);

				}
				dataObj.setAcmSubList(subList);

				obj.add(dataObj);

			}

			return obj;
		}

	}

	/*
	 * @Override public boolean delete(long id) { try { repository.deleteById(id);
	 * return true;
	 * 
	 * } catch (Exception ex) { log.error(ex); return false; } }
	 * 
	 */

}
