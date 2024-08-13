package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"chosenAddress"})
@Getter
@Setter

@Entity
@Table(name = "users")
//@SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 100, allocationSize = 1)

public class User extends BaseEntity{
//	@Column
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//    private Long id;
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	protected void onCreate() {
        if (this.id == null) {
            this.id = (long) 10;
        }}
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="password")
	private String password;
	
	//primary key
	@Column(name="email",unique=true)
	private String email;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "address_id",nullable=true)
	private Address chosenAddress;
	
	@Column(name="contact_info")
	private String contact;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Role role=Role.CUSTOMER;
	
//	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
//	private List<Order> orders=new ArrayList<>();
//	
//	public void addOrder(Order order)
//	{
//		//add a post ref to the list of posts in category
//		orders.add(order);//parent ---> child
//		order.setUser(this);//child --> parent		
//	}
//	public void removeOrder(Order user)
//	{
//		orders.remove(user);
//		user.setUser(null);
//	}
}
