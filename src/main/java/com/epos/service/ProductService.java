package com.epos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epos.model.ProductDetails;
import com.epos.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo prodRepo;

    public ProductDetails addProduct(ProductDetails prod) {
        return prodRepo.save(prod);
    }

    public List<ProductDetails> findAllProducts() {
        return prodRepo.findAll();
    }

//	public List<Category> findAllCategory(){
//		return prodRepo.findByProd_Category();
//	}
}
