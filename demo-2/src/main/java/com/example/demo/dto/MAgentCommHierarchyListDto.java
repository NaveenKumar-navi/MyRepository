package com.example.demo.dto;

import java.math.BigDecimal;

public interface MAgentCommHierarchyListDto {

	String getAcmCompCode();
	
	String getAcmProdCode();
	
	String getAcmSchFmCode();
	
	String getAcmSchToCode();
	
	String getAcmAgentCode();
	
	String getAcmRmAgentCode();
	
	BigDecimal getAcmLevel();
	
	String getAcmLevelDesc();
	
	BigDecimal getAcmPolTermFm();
	
	BigDecimal getAcmPolTermTo();
}
