package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ConfigurationDTO;
import com.app.service.ConfigurationService;

@RestController
@RequestMapping("/configure")
public class ConfigurationController {
	@Autowired
	private ConfigurationService configurationService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addConfiguration(@RequestBody ConfigurationDTO configurationDto)
	{
		System.out.println("in configuration controller"+configurationDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(configurationService.addConfiguration(configurationDto));
	}

}
