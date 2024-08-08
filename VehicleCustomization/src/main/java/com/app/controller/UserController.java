package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exception.ApiException;
import com.app.dto.ApiResponse;
import com.app.dto.CustomerDTO;
import com.app.dto.LoginDTO;
import com.app.entities.Address;
import com.app.entities.Category;
import com.app.entities.User;
import com.app.service.UserServiceI;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceI userservice;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody CustomerDTO userDto) {
		System.out.println("in user controller" + userDto);
		//return ResponseEntity.status(HttpStatus.CREATED).body(userservice.addCustomer(userDto));
		try {
			User user=userservice.addCustomer(userDto);
			return ResponseEntity.ok(user);
		}catch(RuntimeException e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	
//	@PutMapping("/update/{userId}")
//	public ResponseEntity<?> updateCustomer(@PathVariable Long userId,Address address)
//	{
//		try {
//			User user=
//			return ResponseEntity.ok(user);
//		}catch(RuntimeException e)
//		{
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
//		}
//		
//	}

	@PostMapping("/signin")
	public ResponseEntity<?> LoginByEmailPassword(@RequestBody LoginDTO loginDto) {
		try {
			User user = userservice.authenticateUser(loginDto);
			return ResponseEntity.ok(user);
		} catch (RuntimeException e) {
			// invalid login
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAllCustomer() {
		try {
			List<User> users = userservice.getAllUsers();
			return ResponseEntity.ok(users);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
//	@DeleteMapping("/deleteUser")
//	public ResponseEntity<?> deleteUserById(@PathVariable Long id);

}
