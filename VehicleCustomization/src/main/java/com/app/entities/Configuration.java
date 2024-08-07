package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id", nullable = true)
	private Category chosenCategory;
	
	@Column(nullable=true)
	private String partName;
	
	
//	   @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "order_id") // Foreign key column in the configuration table
//	    private Order order;

}
