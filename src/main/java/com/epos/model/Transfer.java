package com.epos.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
//@Entity
//@Table(name="epos_transfer")
public class Transfer {

	@Id
	private String transfer_Id;

	private String stockTo;
	private String stockFrom;
	private Date transferDate;
	private Date recordDate;
	private String transferComment;
	private String transferStatus;
	
}
