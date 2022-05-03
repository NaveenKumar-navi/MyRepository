package com.example.demo.bean;

import java.math.BigDecimal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shop")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	
	@Size(max = 12, message = "PSAF_COMP_CODE should have at least 12 characters")
	private String productName;
	

	@Size(max = 12, message = "Color should have at least 12 characters")
	private String color;
	
	
	@Size(max = 12, message = "PSAF_COMP_CODE should have at least 12 characters")
	private String size;
	
	
	@Size(max = 12, message = "PSAF_COMP_CODE should have at least 12 characters")
	private String imageUrl;
	

	private BigDecimal rate;
	
	
	private BigDecimal quantity;
}
