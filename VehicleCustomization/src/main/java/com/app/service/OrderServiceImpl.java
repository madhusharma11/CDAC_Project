package com.app.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OrderRepository;
import com.app.dto.OrderDTO;
import com.app.entities.Category;
import com.app.entities.ConfigurationModel;
import com.app.entities.Order;
import com.app.entities.PaymentStatus;
import com.app.entities.User;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserServiceI userservice;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ConfigurationModelService configurationModelService;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Order addOrder(OrderDTO orderDto) {
		Order order = new Order();
		double amount = 0;

		Long userId = orderDto.getUserId();
		Long categoryId = orderDto.getCategoryId();
		Set<Long> configureModelList = orderDto.getConfigurationModelId();

		User user = userservice.getById(userId);
		order.setUser(user);

		Category category = categoryService.getByCategoryId(categoryId);
		order.setCategory(category);
		// using getConfigurationModels we reuse already ctreated set which is in
		// configModele class
		// we also use newly created set instead of this
		for (Long configModelId : configureModelList) {

			ConfigurationModel configurationModel = configurationModelService.getById(configModelId);
			amount = amount + configurationModel.getModelPrice();
			order.getConfigurationModels().add(configurationModel);
		}
		order.setTotalAmount(amount);
		order.setStatus(PaymentStatus.PENDING);
		orderRepository.save(order);

		return order;
	}

}
