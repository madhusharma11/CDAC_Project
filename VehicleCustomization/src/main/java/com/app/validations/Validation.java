package com.app.validations;

import java.util.List;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.entities.Address;
import com.app.entities.Role;
import com.app.entities.User;

public class Validation {


	//VALIDATE FOR ENUM VALUES
	public static  Role parseRole(String role)
	{
		Role role1=Role.valueOf(role.toUpperCase());
		return role1;
	}


	//VALIDATE FOR DUPLICATE EMAIL
	public static String validatEmail (User[] arrCustomer,String email)throws InvalidCredentialsException
	{
		for(User u:arrCustomer)
		{
			if(u!=null && u.getEmail().equals(email))
				throw new InvalidCredentialsException("This Email is already used.");
		}
		return email;
	}


	//Update password
/*
	public static void changePassword(Customer[] arrCustomer,String email,String oldPass,String newPass)throws UserNotRegistered
	{
		boolean flag=false;
		for(Customer c:arrCustomer)
		{
			if((c!=null && c.getEmail().equals(email))&&(c.getPassword().equals(oldPass))) 
			{
				c.setPassword(newPass);
				System.out.println("New password successfully set.");
				flag=true;
				break;
			}
		}
		if(flag==false) 
			throw new UserNotRegistered("Email or Old password are incorrect.");
	}
	*/
	
	//VALIDATE CUSTOMER'S ALL INPUT
	//String fname, String lname, String gmail, String pwd, LocalDate dateOfBirth,
	//ServicePlan value,double registrationAmount
	/*public static User validateCustomer(List<User> userList,String fname,String lname,String email,String password,Address chosenAddress,String contact,Role role) throws InvalidCredentialsException
	{
		
	
	
		validatEmailFormat(email);
		validatPassword(password);
		String emal=checkForDuplicateCustomer(userList,email);

		return new Customer(fname,lname,emal,password,dateOfBirth,value,amount);
	}
*/
	// madhusharma@gmail.com
	public static void validatEmailFormat(String email)throws InvalidCredentialsException
	{
		//if(email.contains("@gmail.com")&&(email.endsWith("@gmail.com")))
		if(email.contains("@"))
		{
			String[] arr=email.split("@");
			if(!((arr.length==2)&&(email.endsWith("gmail.com"))))
				throw new InvalidCredentialsException("Invalid Email Id Format!!!");
		}
		else
			throw new InvalidCredentialsException("Invalid Email Id Format!!!");
	}
	
	
//STRONG PASSWORD0	1abcde@
//	public static void validatPassword(String password)throws Customer_Exceptions
//	{
//		
//		String regex="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
//		
//		
//		if(!password.matches(regex)==true)
//		System.out.println("validate password");
//			throw new Customer_Exceptions("Password must contain 5 character::must have atleat one number and one letter!!!");
//		
//	}
	
	public static void validatPassword(String password)throws InvalidCredentialsException
	{
		if(!password.matches("(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,}$"))
		throw new InvalidCredentialsException("Password must contain 5 character::must have atleat one number and one letter!!!");
			
	}
	/*
	
	public static int parseAndValidateDob(String dob) 
	{
		LocalDate dateOfBirth=parseDOB(dob);		
		Period years=Period.between(dateOfBirth,LocalDate.now());
		
		return years.getYears();
	}
}
*/
}
