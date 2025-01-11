package com.epos.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name="epos_customer")
public class Customer {

	@Id
	private long customerId;

	private String customerName;
	private long customerPhone;
	private String customerAddress;
	private String customerCountry;
	private long customerRewardPoints;
}
