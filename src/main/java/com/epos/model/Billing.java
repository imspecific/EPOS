package com.epos.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
//@Entity
//@Table(name="epos_billing")
public class Billing {

	@Id
	private String billNo;

	private Date billDate;
	private String employeeId;
	private String customerId;
	private String paymentCurrency;
	private long paymentAmount;
	private long cardTransactionNo;
	private long cardAmount;
	private long rewardPoints;
	private String returnCurrency;
	private long returnAmount;
}
