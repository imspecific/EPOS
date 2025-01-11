package com.epos.service;

import java.util.List;

import com.epos.model.Store;
import com.epos.repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

	@Autowired
	private StoreRepo storeRepo;
	
	public Store addStore(Store store) {
		return storeRepo.save(store);
	}
	
	public List<Store> allStore(){
		return storeRepo.findAll();
	}
}
