package com.epos.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "epos_store")
public class Store {

    @Id
    private long storeId;

    private String storeAddress;
    private String storeCountry;
    private String storeEmail;
    private String storeName;
    private long storePhone;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductDetails> products;
}
