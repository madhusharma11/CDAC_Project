package com.app.entities;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
=======

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
>>>>>>> 54efb52f21eb5ee405343475e6895fdb61cf3fec
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

<<<<<<< HEAD
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


=======
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(nullable = false)
	private String status ;
	
	@Column(name="booking_date")
	private LocalDate bookingdate ;
	
	@Column(nullable = false)
	private double payment ; 
	
	
	
	
}
>>>>>>> 54efb52f21eb5ee405343475e6895fdb61cf3fec
