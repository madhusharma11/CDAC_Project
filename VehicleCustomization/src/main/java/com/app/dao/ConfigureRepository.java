package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Configuration;


public interface ConfigureRepository extends JpaRepository<Configuration, Long>{
	 @Query(value = "SELECT * FROM configurations WHERE category_id = :categoryId", nativeQuery = true)
	  List<Configuration> findByCategoryId(@Param("categoryId") Long categoryId);
}
