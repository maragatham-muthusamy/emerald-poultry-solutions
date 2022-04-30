package com.maha.spring;

public class User {

	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	public User() {
		
	}

	public String getFirstName() {
		return firstname;
	}
	
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
