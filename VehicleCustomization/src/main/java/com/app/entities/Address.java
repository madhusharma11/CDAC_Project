package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="address")

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"user"})
public class Address extends BaseEntity {
	@Column(name="adr_line1",length=100)
	private String adrLine1;
	@Column(name="adr_line2",length=100)
	private String adrLine2;
	@Column(length=20)
	private String city;
	@Column(length=20)
	private String state;
	@Column(length=20)
	private String country;
	@Column(length=20,name="zip_code")
	private String zipCode;
	
	@OneToMany(mappedBy = "chosenAddress",cascade = CascadeType.ALL ,fetch = FetchType.LAZY )
	//@JsonIgnore //this field will be ignored during both ser n de-ser.
	private List<User> users=new ArrayList<>();
	
	

	public void addUser(User user)
	{
		//add a post ref to the list of posts in category
		users.add(user);//parent ---> child
		user.setChosenAddress(this);//child --> parent		
	}
	public void removeUser(User user)
	{
		users.remove(user);
		user.setChosenAddress(null);
	}
	public String getAdrLine1() {
		return adrLine1;
	}
	public void setAdrLine1(String adrLine1) {
		this.adrLine1 = adrLine1;
	}
	public String getAdrLine2() {
		return adrLine2;
	}
	public void setAdrLine2(String adrLine2) {
		this.adrLine2 = adrLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
