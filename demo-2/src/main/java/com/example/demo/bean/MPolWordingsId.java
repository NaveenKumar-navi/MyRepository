package com.example.demo.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MPolWordingsId implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal pwSysId;

	private BigDecimal pwProductCode;

	private String pwWordingType;

	private String pwCoverCode;
}