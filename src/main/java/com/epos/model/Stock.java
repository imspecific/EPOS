package com.epos.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
//@Entity
//@Table(name="epos_stock")
public class Stock {

	@Id
	private String storeId;
	private String productId;
	private long quantity;
	private int minQuantity;
}
