package com.epos.model;

import lombok.Data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
//@Entity
//@Table(name="epos_supplier")
public class Supplier {

	@Id
	private Long supplierId;

	private String supplierName;
	private long supplierPhone;
	private String supplierEmail;
	private String supplierAddress;
	private String supplierCountry;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ProductDetails> products;
}
