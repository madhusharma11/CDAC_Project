package com.app.service;

import com.app.dto.CustomerDTO;
import com.app.entities.User;

public interface UserServiceI {
	User addCustomer(CustomerDTO userDto);

}
