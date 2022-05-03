package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MPolWordingsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal pwSysId;

	private BigDecimal pwProductCode;

	private String pwWordingType;

	private String pwCoverCode;

	private String pwPageName;

	private BigDecimal pwPageno;

	private String pwLvl;

	private BigDecimal pwPageLineNo;

	private String pwPageOrder;

	private String pwDisplayText1;

	private String pwAllignment;

	private String pwFontsize;

	private String pwTextformat;

	private String pwDisplayText2;

	private String pwDisplayText3;

	private String pwDynamicColumn1;

	private String pwDynamicColumn2;

	private String pwDynamicColumn3;

}

