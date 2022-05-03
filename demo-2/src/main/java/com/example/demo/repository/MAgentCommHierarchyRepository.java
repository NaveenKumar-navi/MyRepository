package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.MAgentCommHierarchy;
import com.example.demo.dto.MAgentCommHierarchyListDto;


public interface MAgentCommHierarchyRepository
		extends JpaRepository<MAgentCommHierarchy, BigDecimal>, JpaSpecificationExecutor<MAgentCommHierarchy> {

	Optional<MAgentCommHierarchy> findByAcmAgentCode(String agentCode);

	@Query(value = "select * from M_AGENT_COMM_HIERARCHY where upper(concat(ACM_AGENT_CODE,ACM_RM_AGENT_CODE)) like upper(:search)", nativeQuery = true)
	Page<MAgentCommHierarchy> findAll(@Param("search") String search, Pageable paging);

	Optional<MAgentCommHierarchy> findByAcmSchFmCode(String acmSchFmCode);

	Optional<MAgentCommHierarchy> findByAcmAgentCodeAndAcmCompCodeAndAcmProdCodeAndAcmSchFmCode(String acmAgentCode,
			String acmCompCode, String acmProdCode, String acmSchFmCode);

	@Query(value = "select distinct acm_agent_code as acmAgentCode,acm_comp_code as acmCompCode,acm_prod_code as acmProdCode,acm_sch_fm_code as acmSchFmCode,acm_sch_to_code as amcSchToCode,acm_rm_agent_code as acmRmAgentCode,acm_level as acmLevel,acm_level_desc as acmLevelDesc,acm_pol_term_fm as acmPolTermFm,acm_pol_term_to as acmPolTermTo from m_agent_comm_hierarchy", nativeQuery = true)
	Page<MAgentCommHierarchyListDto> findByAll(Pageable paging);

	@Query(value = "select distinct acm_agent_code as acmAgentCode,acm_comp_code as acmCompCode,acm_prod_code as acmProdCode,acm_sch_fm_code as acmSchFmCode,acm_sch_to_code as amcSchToCode,\r\n"
			+"acm_rm_agent_code as acmRmAgentCode,acm_level as acmLevel,acm_level_desc as acmLevelDesc,acm_pol_term_fm as acmPolTermFm,\r\n"
			+"acm_pol_term_to as acmPolTermTo from m_agent_comm_hierarchy where upper(concat(concat(concat(concat(concat(concat(concat(acm_comp_code,acm_prod_code),acm_sch_fm_code),\r\n"
			+"acm_agent_code,acm_rm_agent_code),acm_level),acm_level_desc),acm_pol_term_fm),acm_pol_term_to)) like Upper(:sear)", nativeQuery = true)
	Page<MAgentCommHierarchyListDto> findBySearch(@Param("sear") String sear, Pageable paging);

	List<MAgentCommHierarchy> findByAcmCompCodeAndAcmProdCodeAndAcmSchFmCodeAndAcmAgentCodeAndAcmRmAgentCodeAndAcmLevelAndAcmLevelDescAndAcmPolTermFmAndAcmPolTermTo(
			String acmCompCode, String acmSchFmCode, String acmProdCode, String acmAgentCode, String acmRmAgentCode,
			BigDecimal acmLevel, String acmLevelDesc, BigDecimal acmPolTermFm, BigDecimal acmPolTermTo);


	List<MAgentCommHierarchy> findByAcmCompCodeAndAcmProdCodeAndAndAcmSchFmCodeAndAcmAgentCodeAndAcmRmAgentCodeAndAcmLevelAndAcmLevelDescAndAcmPolTermFmAndAcmPolTermTo(
			String acmAgentCode, String acmCompCode, String acmProdCode, String acmSchFmCode, String acmRmAgentCode,
			BigDecimal acmLevel, String acmLevelDesc, BigDecimal acmPolTermFm, BigDecimal acmPolTermTo);

}
