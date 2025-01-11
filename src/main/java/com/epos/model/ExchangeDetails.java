package com.epos.model;

import lombok.Data;

@Data
public class ExchangeDetails {


    private String billNo;
    private String productId;
    private long quantity;
    private long price;
}
