package com.epos.repository;

import java.util.List;

import com.epos.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductDetails, Long> {

	
	//List<Category> findByProd_Category();
	
}
