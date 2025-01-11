package com.epos.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="epos_employee")
public class Employee {

	@Id
	@GeneratedValue
	private Long employeeId;
		
	private String employeeName;
	private String employeeDomain;
	private long employeePhone;
	private String employeeEmail;
	private String employeeAddress;
	private String employeeCountry;
	private Date employeeDOB;
	private Date employeeDOJ;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store storeId;
}
