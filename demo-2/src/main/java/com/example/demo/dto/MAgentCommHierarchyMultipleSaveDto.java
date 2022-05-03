package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MAgentCommHierarchyMultipleSaveDto {

	private String acmCompCode;
	
	private String acmProdCode;
	
	private String acmSchFmCode;
	
	private String acmSchToCode;
	
	private String acmAgentCode;
	
	private String acmRmAgentCode;
	
	private BigDecimal acmLevel;
	
	private String acmLevelDesc;
	
	private BigDecimal acmPolTermFm;
	
	private BigDecimal acmPolTermTo;
	
	private Boolean check;
	
	private List<MAgentCommHierarchySubListDto> acmSubList;
	
}
