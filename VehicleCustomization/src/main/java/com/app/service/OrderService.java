package com.app.service;

import com.app.dto.OrderDTO;
import com.app.entities.Order;

public interface OrderService {

	Order addOrder(OrderDTO orderDto);

}
