package com.example.graphql.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String storeName;

	private String storeDescription;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "capital_id", referencedColumnName = "id")
	private Product capital;
}
