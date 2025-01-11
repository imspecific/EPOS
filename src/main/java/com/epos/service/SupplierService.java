package com.epos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epos.model.Supplier;
import com.epos.repository.SupplierRepo;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepo supplierRepo;
	
	public Supplier addSupplier(Supplier supplier) {
		return supplierRepo.save(supplier);
	}
	
	public List<Supplier> findAllSupplier(){
		return supplierRepo.findAll();
	}
	
	public List<Supplier> findSupplierBySup_Id(Iterable<Long> sup_Id){
		return supplierRepo.findAllById(sup_Id);
	}
	
}
