package com.example.demo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamicInsert
@DynamicUpdate
@Builder
@Entity
@Table(name = "M_AGENT_COMM_HIERARCHY")
@EntityListeners(AuditingEntityListener.class)
public class MAgentCommHierarchy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ACM_ID")
	@SequenceGenerator(sequenceName = "S_ACM_ID", allocationSize = 1, name = "S_ACM_ID")
	@Column(name = "ACM_SYS_ID")
	private BigDecimal acmSysId;

	@Column(name = "ACM_COMP_CODE")
	private String acmCompCode;

	@Column(name = "ACM_PROD_CODE")
	private String acmProdCode;

	@Column(name = "ACM_SCH_FM_CODE")
	private String acmSchFmCode;

	@Column(name = "ACM_SCH_TO_CODE")
	private String acmSchToCode;

	@Column(name = "ACM_AGENT_CODE")
	private String acmAgentCode;

	@Column(name = "ACM_RM_AGENT_CODE")
	private String acmRmAgentCode;

	@Column(name = "ACM_LEVEL")
	private BigDecimal acmLevel;

	@Column(name = "ACM_LEVEL_DESC")
	private String acmLevelDesc;

	@Column(name = "ACM_POL_TERM_FM")
	private BigDecimal acmPolTermFm;

	@Column(name = "ACM_POL_TERM_TO")
	private BigDecimal acmPolTermTo;

	@Column(name = "ACM_POL_YEAR_FM")
	private BigDecimal acmPolYearFm;

	@Column(name = "ACM_POL_YEAR_TO")
	private BigDecimal acmPolYearTo;

	@Column(name = "ACM_COMM_RATE")
	private BigDecimal acmCommRate;

	@Column(name = "ACM_COMM_TARGET_RATE")
	private BigDecimal acmCommTargetRate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACM_EFF_FM_DT")
	private Date acmEffFmDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACM_EFF_TO_DT")
	private Date acmEffToDt;

	@Column(name = "ACM_STATUS")
	private String acmStatus;

	@CreatedBy
	@Column(name = "ACM_CR_UID")
	private String acmCrUid;

	@CreatedDate
	@Column(name = "ACM_CR_DT")
	private LocalDateTime acmCrDt;

	@LastModifiedBy
	@Column(name = "ACM_UPD_UID")
	private String acmUpdUid;

	@LastModifiedDate
	@Column(name = "ACM_UPD_DT")
	private LocalDateTime acmUpdDt;

	@Column(name = "ACM_COMM_TYPE")
	private String acmCommType;

}
