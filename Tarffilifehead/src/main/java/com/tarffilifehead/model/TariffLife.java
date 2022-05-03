package com.tarffilifehead.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "M_AFFINITY_CODES")
@Entity
public class TariffLife {

	@Id
	private String mtmMapCode;
	@Id
	private String mtmCode;
	private String mtmDesc;
	private String mtmMapFm;
	private String mtmMapTo;
	private String mtmMapName;
	private String mtmCrUid;
	private Date mtmCrDt;
	private String mtmUpdUid;
	private Date mtmUpdDt;
	
}
