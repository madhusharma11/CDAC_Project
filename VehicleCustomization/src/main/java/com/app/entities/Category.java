package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"configurations"})
@NoArgsConstructor
@AllArgsConstructor
@Entity 
public class Category extends BaseEntity{
	

	@Column(name="vehicle_type")
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="category_id",nullable=false)
	private List<Configuration> configurations=new ArrayList<>();

	
//	public void addConfiguration(Configuration configuration)
//	{
//		configurations.add(configuration);
//		configuration.setChosenCategory(this);
//	}
//	
//	public void removeConfiguration(Configuration configuration)
//	{
//		configurations.remove(configuration);
//		configuration.setChosenCategory(null);
//	}
}
