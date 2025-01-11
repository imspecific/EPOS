package com.epos.model;


import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "epos_productdetails")
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
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store storeId;

    @OneToOne(mappedBy = "product")
    private Offer offerId;
}
