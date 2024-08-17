package com.app.service;

import java.util.List;

import com.app.dto.OrderDTO;
import com.app.entities.Order;

public interface OrderService {

	Order addOrder(OrderDTO orderDto);

	Order updatePaymentStatusById(Long order_id);

	List<Order> orderByUserId(Long user_id);

}
