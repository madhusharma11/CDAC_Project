package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"chosenAddress"})
@Getter
@Setter
@Table(name="users")
public class User extends BaseEntity{
	
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="password")
	private String password;
	
	//primary key
	@Column(name="email",unique=true)
	private String email;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id",nullable=true)
	private Address chosenAddress;
	
	@Column(name="contact_info")
	private String contact;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Role role;

}
