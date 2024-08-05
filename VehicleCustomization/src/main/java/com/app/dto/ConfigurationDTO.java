package com.app.dto;

import javax.persistence.Column;

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
public class ConfigurationDTO {
	private String part;
	private String partModel;
	private String description;
	private double price;
	

}
