package com.epos.repository;

import java.util.List;

import com.epos.model.Category;

public interface CategoryRepo {

	int save(Category category);
	
	List<Category> findAllCategory();
}
