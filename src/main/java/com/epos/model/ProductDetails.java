package com.epos.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="epos_productdetails")
public class ProductDetails {

	@Id
	private Long productId;
	private String productName;
	
	@Embedded
	@AttributeOverrides(value = {
		        @AttributeOverride(name = "productCategory", column = @Column(name = "product_category")),
		        @AttributeOverride(name = "productBrand", column = @Column(name = "product_brand"))
		    })
	private Category category;
	
	//private String prodBrand;
	private String productSize;
	private String productColour;
	private long productPrice;
	private long productPurchasePrice;
	
	@ManyToOne
	@JoinColumn(name="sup_id")
	private Supplier supId;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store storeId;
	
	@OneToOne(mappedBy = "product")
	private Offer offerId;
}
