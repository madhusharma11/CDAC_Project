package com.app.entities;

import java.time.LocalDate;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="orders")
public class Order extends BaseEntity{
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	@Column(name="payment_status",nullable = false)
	private PaymentStatus status=PaymentStatus.PENDING ;
	
	@Column(name="booking_date",nullable = false)
	private LocalDate bookingdate ;
	
	@Column(name="totalAmount",nullable = false)
	private double totalAmount ; 
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=true)
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="category_id",nullable=true)
	private Category category;
	
//	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
//	 private List<Configuration> configurations;
	
	@ManyToMany //mandatory o.w --Mapping Exception
	//to customise the join table
	@JoinTable(name="order_configuration",
	joinColumns = @JoinColumn(name="order_id"),
	inverseJoinColumns = @JoinColumn(name="configuration_id")
	)
	private Set<ConfigurationModel> configurationMOodels=new HashSet<>();
 
}


