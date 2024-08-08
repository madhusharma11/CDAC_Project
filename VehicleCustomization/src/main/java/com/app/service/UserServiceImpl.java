package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.ResourceNotFoundException;
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
				() -> new InvalidCredentialsException("Invalid Email or Password!!!"));
		System.out.println(user);
		return mapper.map(user, User.class);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users=userRepository.findAll();
		return users;
	}

	@Override
	public User updateCustomer(Long id, CustomerDTO userdto) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found!"));
		mapper.map(userdto, existingUser);
		User updatedUser = userRepository.save(existingUser);
		return mapper.map(updatedUser, User.class);
	}

	

	
}
