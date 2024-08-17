package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter

@ToString(exclude = { "configurations" })
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = false)
@Entity
@Table(name = "categories")
//@SequenceGenerator(name = "category_seq", sequenceName = "category_sequence", initialValue = 1000, allocationSize = 2)

public class Category extends BaseEntity {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Setter
	@Column(name = "vehicle_type")
	private String name;
	
	@Column(name="price")
	private double price;

//	@OneToMany(mappedBy = "chosenCategory", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//	private List<Configuration> configurations = new ArrayList<>();
//
//	public void addConfiguration(Configuration configuration) {
//		configurations.add(configuration);
//		configuration.setChosenCategory(this);
//	}
//
//	public void removeConfiguration(Configuration configuration) {
//		configurations.remove(configuration);
//		configuration.setChosenCategory(null);
//	}
}
