package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	//Category save(Category category);

}

