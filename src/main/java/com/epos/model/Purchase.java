package com.epos.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
//@Entity
//@Table(name="epos_purchase")
public class Purchase {

	@Id
	private String invoiceNo;

	private Date purchaseDate;
	private String supplierId;
	private long totalAmount;
	private long amountPaid;
	private long amountDue;
	private String transferId;
}
