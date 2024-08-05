package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.dto.CustomerDTO;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public User addCustomer(CustomerDTO userDto) {
		System.out.println(userDto);
		User userEntity=mapper.map(userDto,User.class);
		User savedcust=userRepository.save(userEntity);
		return mapper.map(savedcust, User.class);
	}

	}
	

