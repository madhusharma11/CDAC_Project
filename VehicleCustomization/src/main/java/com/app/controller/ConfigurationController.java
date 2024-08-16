package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exception.ApiException;
import com.app.dto.ApiResponse;
import com.app.dto.ConfigurationDTO;
import com.app.entities.Category;
import com.app.entities.Configuration;
import com.app.entities.ConfigurationModel;
import com.app.service.ConfigurationModelService;
import com.app.service.ConfigurationService;

@RestController
@RequestMapping("/configure")
public class ConfigurationController {
	@Autowired
	private ConfigurationService configurationService;
@Autowired private ConfigurationModelService configurationModelService;
	@PostMapping("/add")
	public ResponseEntity<?> addConfiguration(@RequestBody ConfigurationDTO configurationDto) {
		System.out.println("in configuration controller" + configurationDto);
		// return
		// ResponseEntity.status(HttpStatus.CREATED).body(configurationService.addConfiguration(configurationDto));
		try {
			Configuration config = configurationService.addConfiguration(configurationDto);
			return ResponseEntity.ok(config);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException("Not Added!!!"));
		}
	}

	@GetMapping("/findByCatId/{category_id}")
	public ResponseEntity<?> getConfigurationByCategoryId(@PathVariable("category_id") Long category_id) {
		try {
			System.out.println();
			List<Configuration> configurations = configurationService.getConfiguration(category_id);
			return ResponseEntity.ok(configurations);

		} catch (RuntimeException e) {
			System.out.println(e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	

	@GetMapping("/findByConfigModelId/{configModel_id}")
	public ResponseEntity<?> getConfigurationModelByCategoryId(@PathVariable("configModel_id") Long configModel_id) {
		try {
			System.out.println();
			ConfigurationModel configurationmodel = configurationModelService.getById(configModel_id);
			return ResponseEntity.ok(configurationmodel);

		} catch (RuntimeException e) {
			System.out.println(e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	
	@GetMapping("/findByConfigId/{config_id}")
	public ResponseEntity<?> getConfigurationById(@PathVariable("config_id") Long config_id) {
		try {
			System.out.println();
			Configuration configuration = configurationService.getById(config_id);
			return ResponseEntity.ok(configuration);

		} catch (RuntimeException e) {
			System.out.println(e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}


}
