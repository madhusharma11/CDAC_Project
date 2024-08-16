package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.OrderDTO;
import com.app.entities.Category;
import com.app.entities.Order;
import com.app.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addOrder")
	public ResponseEntity<?> placeOrder(@RequestBody OrderDTO orderDto)
	{
		
		try {
			Order order=orderService.addOrder(orderDto);
			return ResponseEntity.ok(order);
			
		}catch(RuntimeException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PutMapping("/updatePaymentStatus/{order_id}")
	public ResponseEntity<?> updatePaymentStatusById(@PathVariable("order_id") Long order_id) {
		try {
			System.out.println();
			Order order = orderService.updatePaymentStatusById(order_id);
			return ResponseEntity.ok(order);

		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	
}
