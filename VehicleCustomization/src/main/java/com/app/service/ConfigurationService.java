package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.ConfigurationDTO;
import com.app.entities.Configuration;

public interface ConfigurationService {

	Configuration addConfiguration(ConfigurationDTO configurationDto);

	List<Configuration> getConfiguration(Long category_id);

	Configuration getById(Long config_id);

}
