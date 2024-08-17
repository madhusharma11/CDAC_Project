package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	 @Query(value = "SELECT * FROM orders WHERE user_id = :userId", nativeQuery = true)
	  List<Order> findByUserId(@Param("userId") Long userId);
}
