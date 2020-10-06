package com.flexon.registration.SpringBootArtifacts;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UsersDAO userService;
	
	@GetMapping(path="/users")
	public ArrayList<User> printAllStudents(){
		return userService.printUsers();
	}
	
//	@PostMapping(path="/addStudent")
//	@ResponseStatus(HttpStatus.OK)
//	public String addStudent(@RequestBody Students newStudent) {
//		studentService.addNewStudent(newStudent);
//		return "Sucessfully Added Student";
//	}
	
	
//	@RequestMapping(method=RequestMethod.GET, path ="/my-service")
//	public String myGetMethod() {
//		return "This is my first service using a URI!!";		
//	}
	
	//Simplify using Get Mapping
	
//	@GetMapping(path ="/get-my-service")
//	public String myServiceImproved() {
//		return "This is my first simplified get service call!!";		

}
