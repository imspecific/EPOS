package com.epos.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
//@Entity
//@Table(name="epos_excahnge")
public class Exchange {

	@Id
	private String employeeId;
	private String billNo;
	private Date exchangeDate;
}
