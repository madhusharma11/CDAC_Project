package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ConfigurationModelRepository;
import com.app.entities.ConfigurationModel;

@Service
@Transactional
public class ConfigurationModelServiceImpl implements ConfigurationModelService {
	@Autowired
	private ConfigurationModelRepository configurationModelRepository;

	@Override
	public ConfigurationModel getById(Long configurationModeId) {
		ConfigurationModel configurationModel = configurationModelRepository.findById(configurationModeId)
				.orElseThrow(() -> new com.app.custom_exception.InvalidCredentialsException("Invalid Category!!!"));
		return configurationModel;
	}
}