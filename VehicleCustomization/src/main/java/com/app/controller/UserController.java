package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerDTO;
import com.app.entities.User;
import com.app.service.UserServiceI;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceI userservice;
	
	@PostMapping("/insert")
	public ResponseEntity<?> addNewUser(@RequestBody  CustomerDTO userDto)
	{
		System.out.println("in user controller"+userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.addCustomer(userDto));
		
	}
	/*
	@PostMapping("/insert")
	public ResponseEntity<?> addNewUser(@RequestBody  User user)
	{
		System.out.println("in user controller"+user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.addCustomer(user));
		
	}
	*/

}
