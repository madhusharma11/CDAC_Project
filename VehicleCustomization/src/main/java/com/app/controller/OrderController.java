package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.custom_exception.ApiException;
import com.app.entities.Order;
import com.app.service.OrderService;

public class OrderController {
	
	@Autowired
	private OrderService orderservice ;
	
	//For Admin 
	@GetMapping("/getAllOrders")
	public ResponseEntity<?> getAllOrders() {
		try {
			List<Order> orders = orderservice.getAllOrders();
			System.out.println(orders);
			return ResponseEntity.ok(orders);
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException(e.getMessage()));
		}

	}


}
