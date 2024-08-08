package com.app.service;

import java.util.List;

import com.app.dto.CustomerDTO;
import com.app.dto.LoginDTO;
import com.app.entities.User;

public interface UserServiceI {
	User addCustomer(CustomerDTO userDto);

	 User authenticateUser(LoginDTO loginDto);
	 List<User> getAllUsers();

	User getById(Long id);

}
