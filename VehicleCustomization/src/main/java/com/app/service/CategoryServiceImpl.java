package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryRepository;
import com.app.entities.Category;
import com.app.entities.User;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
@Autowired
private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {		
		Category savedcategory=categoryRepository.save(category);
		return savedcategory;
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories=categoryRepository.findAll();
		return categories;
	}
	
	
	// User user=userRepository.findById(id).orElseThrow
	//(()->new com.app.custom_exception.InvalidCredentialsException("User not registered!!!"));;
		
	@Override
	public Category getByCategoryId(Long categoryId)
	{
		Category category=categoryRepository.findById(categoryId).orElseThrow(()->new com.app.custom_exception.InvalidCredentialsException("Invalid Category!!!"));
		return category;
	}

}
