package com.epos.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
//@Entity
//@Table(name="epos_transferdetails")
public class TransferDetails {

	@Id
	private String transferId;
	
	private String productId;
	private long quantity;
	private long pendingQuantity;
	private long recordQuantity;
	
}
