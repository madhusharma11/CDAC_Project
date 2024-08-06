package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@Column(name="payment_status",nullable = false)
	private PaymentStatus status ;
	
	@Column(name="booking_date",nullable = false)
	private LocalDate bookingdate ;
	
	@Column(name="payment",nullable = false)
	private double payment ; 
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="address_id",nullable=false)
	private Address address;
	
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
	    private List<Configuration> configurations;
 
}


