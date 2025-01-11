package com.epos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class Category implements Serializable {

    private String productCategory;
    private String productBrand;

    public Category(String productCategory, String productBrand) {
    }
}