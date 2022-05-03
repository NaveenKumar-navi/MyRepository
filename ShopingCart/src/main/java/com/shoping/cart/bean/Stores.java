package com.shoping.cart.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stores")
public class Stores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long store_id;

	@Column(name = "store_name", nullable = false)
	@NotEmpty(message = "StoreName required")
	private String storeName;

	@Column(name = "store_description", nullable = false)
	@NotEmpty(message = "StoreDescription required")
	private String storeDescription;

}
