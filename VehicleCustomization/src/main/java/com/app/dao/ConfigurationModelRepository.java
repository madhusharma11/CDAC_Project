package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ConfigurationModel;

public interface ConfigurationModelRepository extends JpaRepository<ConfigurationModel, Long> {
}
