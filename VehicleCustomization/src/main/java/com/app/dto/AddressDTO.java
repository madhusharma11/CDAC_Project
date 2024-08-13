package com.app.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AddressDTO {
  
	private String adrLine1;
	
	private String adrLine2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipCode;
}
