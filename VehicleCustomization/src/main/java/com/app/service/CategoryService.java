package com.app.service;

import java.util.List;

import com.app.entities.Category;

public interface CategoryService {

	Category addCategory(Category category);

	List<Category> getAllCategories();
	
	

}
