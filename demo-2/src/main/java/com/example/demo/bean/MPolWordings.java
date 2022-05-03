package com.example.demo.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@Table(name = "M_POL_WORDINGS")
@IdClass(MPolWordingsId.class)
@EntityListeners(AuditingEntityListener.class)
public class MPolWordings implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PW_SYS_ID")
	@SequenceGenerator(sequenceName = "S_PW_SYS_ID", allocationSize = 1, name = "S_PW_SYS_ID")
	@Column(name = "PW_SYS_ID", nullable = false)
	private BigDecimal pwSysId;

	@Id
	@Column(name = "PW_PRODUCT_CODE", nullable = false)
	private BigDecimal pwProductCode;

	@Id
	@Column(name = "PW_WORDING_TYPE", nullable = false, length = 50)
	private String pwWordingType;

	@Id
	@Column(name = "PW_COVER_CODE", nullable = false, length = 250)
	private String pwCoverCode;

	// --- ENTITY DATA FIELDS
	@Column(name = "PW_PAGE_NAME", length = 50)
	private String pwPageName;

	@Column(name = "PW_PAGENO")
	private BigDecimal pwPageno;

	@Column(name = "PW_LVL", nullable = false, length = 250)
	private String pwLvl;

	@Column(name = "PW_PAGE_LINE_NO")
	private BigDecimal pwPageLineNo;

	@Column(name = "PW_PAGE_ORDER", length = 10)
	private String pwPageOrder;

	@Column(name = "PW_DISPLAY_TEXT_1", length = 2000)
	private String pwDisplayText1;

	@Column(name = "PW_ALLIGNMENT", length = 1)
	private String pwAllignment;

	@Column(name = "PW_FONTSIZE", length = 10)
	private String pwFontsize;

	@Column(name = "PW_TEXTFORMAT", length = 1)
	private String pwTextformat;

	@Column(name = "PW_DISPLAY_TEXT_2", length = 2000)
	private String pwDisplayText2;

	@Column(name = "PW_DISPLAY_TEXT_3", length = 2000)
	private String pwDisplayText3;

	@Column(name = "PW_DYNAMIC_COLUMN_1", length = 2000)
	private String pwDynamicColumn1;

	@Column(name = "PW_DYNAMIC_COLUMN_2", length = 2000)
	private String pwDynamicColumn2;

	@Column(name = "PW_DYNAMIC_COLUMN_3", length = 2000)
	private String pwDynamicColumn3;

	@Transient
	private String remarks;

	// --- ENTITY LINKS ( RELATIONSHIP )

}

