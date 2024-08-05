package com.app.service;

import org.springframework.stereotype.Service;

import com.app.dto.ConfigurationDTO;
import com.app.entities.Configuration;

public interface ConfigurationService {

	Configuration addConfiguration(ConfigurationDTO configurationDto);

}
