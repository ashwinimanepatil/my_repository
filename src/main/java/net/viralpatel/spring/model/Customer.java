package net.viralpatel.spring.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Customer {
    @NotEmpty(message="Username cannot be empty")
	private String userName;
	  
	@NotEmpty(message="Password cannot be empty")
	private String password;

	public Customer(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Customer() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}