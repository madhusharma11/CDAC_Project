package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Configuration;

public interface ConfigureRepository extends JpaRepository<Configuration, Long>{

}
