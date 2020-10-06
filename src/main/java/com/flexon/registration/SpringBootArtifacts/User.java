package com.flexon.registration.SpringBootArtifacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private int user_id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dateOfBirth;
	private String gender;
	
	public User() {
		super();
		this.setUser_id(0);
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.password = null;
		this.dateOfBirth = null;
		this.gender = null;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public Boolean setFirstName(String fn) {
		if(fn.length() > 2 && fn != null && fn.matches("^[a-zA-Z]*$")) {
			this.firstName = fn;
//			System.out.println("Successfully stored: " + fn);
			return true;
		} else {
			System.out.println("Please enter a valid first name that is longer than two characters without any number and special characters.");
			return false;
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Boolean setLastName(String ln) {
		if(ln.length() > 2 && ln != null && ln.matches("^[a-zA-Z]*$")) {
			this.lastName = ln;
//			System.out.println("Successfully stored: " + ln);
			return true;
		} else {
			System.out.println("Please enter a valid last name that is longer than two characters without any number and special characters.");
			return false;
		}
	}
	
	public String getEmail() {
		return email;
	}
	
	public Boolean setEmail(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      if(email.matches(regex)){
	  		this.email = email;
//			System.out.println("Successfully stored: " + email);
			return true;
	      } else {
	    	System.out.println("Please Enter a valid email format.");
	    	return false;
	      }
	}
	
	public String getPassword() {
		return password;
	}
	
	public Boolean setPassword(String password) {
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		boolean validPassword = isValidPassword(password,regex);
		if(validPassword) {
			this.password = password;
//			System.out.println("Successfully stored: " + password);
			return true;
		} else {
            System.out.println("Password must be less than 20 and more than 8 characters in length, at least one uppercase character, one lowercase character, one number, and one special character among @#$%.");
            return false;
		}
	}
	
	public static boolean isValidPassword(String password,String regex)
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public Boolean setDateOfBirth(String dateOfBirth) {
		if(isValidDate(dateOfBirth)) {
			this.dateOfBirth = dateOfBirth;
//			System.out.println("Successfully stored: " + dateOfBirth);
			return true;
		} else {
			System.out.println("Please enter valid date of birth format.");
			System.out.println("ex) mm/dd/yyyy");
			return false;
		}
	}
	
    public static boolean isValidDate(String d) 
    { 
        String regex = "^(1[0-2]|0[1-9])/(3[01]" + "|[12][0-9]|0[1-9])/[0-9]{4}$"; 
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher((CharSequence)d); 
        return matcher.matches(); 
    } 
	
	public String getGender() {
		return gender;
	}
	
	public Boolean setGender(String gender) {
		String lowGender = gender.toLowerCase();
		if(lowGender.equals("m") || lowGender.equals("male")) {
			this.gender = "Male";
//			System.out.println("Successfully stored: " + this.gender);
			return true;
		} else if(lowGender.equals("f") || lowGender.equals("female")) {
			this.gender = "Female";
//			System.out.println("Successfully stored: " + this.gender);
			return true;
		}
		else {
			System.out.println("Please enter a valid gender");
			System.out.println("ex) Enter 'M' or 'Male' for male, 'F' or 'Female' for female");
			return false;
		}
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
