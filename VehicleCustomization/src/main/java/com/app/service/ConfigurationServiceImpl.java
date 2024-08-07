package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ConfigureRepository;
import com.app.dao.UserRepository;
import com.app.dto.ConfigurationDTO;
import com.app.entities.Configuration;
@Service
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService{
@Autowired
private ConfigureRepository configureRepository;
	
@Autowired
private ModelMapper mapper;

	@Override
	public Configuration addConfiguration(ConfigurationDTO configurationDto) {
		System.out.println(configurationDto);
		Configuration configurationEntity=mapper.map(configurationDto, Configuration.class);
		Configuration savedconfig= configureRepository.save(configurationEntity);
		return mapper.map(savedconfig, Configuration.class);
		
	}

	@Override
	public List<Configuration> getConfiguration(Long category_id) {
		List<Configuration> configurations=configureRepository.findByCategoryId(category_id);
		return configurations;
	}

}
