package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Configuration extends BaseEntity {
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", nullable = true)
	private Category chosenCategory;
	
	@Column(nullable=false)
	private String part;
	
	@Column(nullable=false)
	private String partModel;
	@Column(nullable=false)
	private String description;
	@Column(nullable=false)
	private double price;

}
