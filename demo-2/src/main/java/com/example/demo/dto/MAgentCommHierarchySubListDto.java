package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MAgentCommHierarchySubListDto {

	private BigDecimal acmSysId;
	
	private BigDecimal acmPolYearFm;
	
	private BigDecimal acmPolYearTo;
	
	private BigDecimal acmCommRate;
	
	private BigDecimal acmCommTargetRate;
	
	private Date acmEffFmDt;

	private Date acmEffToDt;

	private String acmStatus;
}
