package com.epos.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
//@Entity
//@Table(name="epos_billingdetails")
public class BillingDetails {

	@Id
	private String billNo;

	private String productId;
	private long productQuantity;
	private long productPrice;
	private long productDiscount;
	private long totalAmount;
}
