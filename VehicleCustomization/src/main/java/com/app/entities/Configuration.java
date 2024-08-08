package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = { "chosenCategory" })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="configurations")
public class Configuration extends BaseEntity {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id", nullable = true)
	private Category chosenCategory;
	
	@Column(nullable=true)
	private String partName;
	
	
	@ManyToMany //mandatory o.w --Mapping Exception//to customise the join table
	@Fetch(FetchMode.JOIN)
	@JoinTable(name="configuration_configurationModles",
	joinColumns = @JoinColumn(name="configurations_id"),
	inverseJoinColumns = @JoinColumn(name="configurationModels_id")
	)
	private Set<ConfigurationModel> configurationModels=new HashSet<>();
 
	
//	   @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "con_id") // Foreign key column in the configuration table
//	    private Order order;

}
