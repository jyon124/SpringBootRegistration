package com.flexon.registration.SpringBootArtifacts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User {
	
	@JsonIgnore  //filter this in response
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String dateOfBirth;
	
	private String gender;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, String password, String dateOfBirth, String gender) {
		super();
		this.setUser_id(0);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String fn) {
		this.firstName = fn;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String ln) {
		this.lastName = ln;
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
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + user_id + ", First Name=" + firstName + ", Last Name=" + lastName + ", email="	+ email + ", Date of Birth=" + dateOfBirth + ","  + " Gender=" + gender + "]";
	}
}
