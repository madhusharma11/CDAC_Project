package com.app.dto;


import com.app.entities.Address;
import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDTO {

	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private Address chosenAddress;
	private String contact;
	private Role role;

}
