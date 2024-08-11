package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.dto.CustomerDTO;
import com.app.dto.LoginDTO;
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
		User userEntity = mapper.map(userDto, User.class);
		User savedcust = userRepository.save(userEntity);
		return mapper.map(savedcust, User.class);
	}

	@Override
	public User authenticateUser(LoginDTO loginDto) throws RuntimeException {
		System.out.println(loginDto);
		User user = userRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword()).orElseThrow(
				() -> new com.app.custom_exception.InvalidCredentialsException("Invalid Email or Password!!!"));
		System.out.println(user);
		return mapper.map(user, User.class);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User getById(Long id) {
      User user=userRepository.findById(id).orElseThrow(
    		  ()->new com.app.custom_exception.InvalidCredentialsException("User not registered!!!"));
	return user;
	}

}
