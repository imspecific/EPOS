package com.epos.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="epos_offer")
public class Offer {
	@Id
	private Long offerId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId",referencedColumnName = "productId")
	private ProductDetails product;
	
	private long discount;
	private long minQty;
	private long status;
	private Date startDate;
	private Date endDate;
}
