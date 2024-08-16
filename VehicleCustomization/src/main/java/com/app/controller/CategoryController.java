package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exception.ApiException;
import com.app.dto.ApiResponse;
import com.app.entities.Category;
import com.app.entities.Configuration;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		try {
			Category catgory=categoryService.addCategory(category);
			return ResponseEntity.ok(catgory);
		}catch(RuntimeException e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException("Not Added!!!"));
		}
		//return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
	}

	@GetMapping("/getAllCategory")
	public ResponseEntity<?> getAllCategories() {
		try {
			List<Category> categories = categoryService.getAllCategories();
			System.out.println(categories);
			return ResponseEntity.ok(categories);
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException("Category is not present!!!"));
		}

	}
	
	@GetMapping("/findByCatId/{category_id}")
	public ResponseEntity<?> getCategoryByCategoryId(@PathVariable("category_id") Long category_id) {
		try {
			System.out.println();
			Category category = categoryService.getByCategoryId(category_id);
			return ResponseEntity.ok(category);

		} catch (RuntimeException e) {
			System.out.println(e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
