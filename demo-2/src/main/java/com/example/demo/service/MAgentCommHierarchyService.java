
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.bean.MAgentCommHierarchy;
import com.example.demo.bean.MAgentCommHierarchyList;
import com.example.demo.dto.MAgentCommHierarchyListDto;
import com.example.demo.dto.MAgentCommHierarchyMultipleSaveDto;


public interface MAgentCommHierarchyService {

	List<MAgentCommHierarchy> getAll();

	Optional<MAgentCommHierarchy> findByAcmAgentCode(String agentCode);

	public void saveorupdate(MAgentCommHierarchy obj);

	Page<MAgentCommHierarchy> findAll(Pageable paging);

	Page<MAgentCommHierarchy> findSearch(String search, Pageable paging);

	Optional<MAgentCommHierarchy> findByAcmSchFmCode(String acmSchFmCode);

	Optional<MAgentCommHierarchy> findByAcmAgentCodeAndAcmCompCodeAndAcmProdCodeAndAcmSchFmCode(String acmAgentCode,
			String acmCompCode, String acmProdCode, String acmSchFmCode);

	void saveorupdate(MAgentCommHierarchyList object);

	Page<MAgentCommHierarchyListDto> findByAll(Pageable paging);

	List<MAgentCommHierarchyMultipleSaveDto> findByValues(Pageable paging);

	Page<MAgentCommHierarchyListDto> findBySearch(String search, Pageable paging);

	List<MAgentCommHierarchyMultipleSaveDto> findBySearchValues(String search, Pageable paging);

}
