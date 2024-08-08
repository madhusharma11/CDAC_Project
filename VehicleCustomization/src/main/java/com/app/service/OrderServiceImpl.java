package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.OrderRepository;
import com.app.entities.Order;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepo ;

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders= orderRepo.findAll();
		return orders;
	}

}
