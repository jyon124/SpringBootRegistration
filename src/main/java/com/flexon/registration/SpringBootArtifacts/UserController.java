package com.flexon.registration.SpringBootArtifacts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	private UserRepository userRepo;
	
	@GetMapping(path="/jpa/users")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@PostMapping(path="/jpa/addNewUser")
	public ResponseEntity<String> addNewStudent(@RequestBody User newUser){
		userRepo.save(newUser);
		return new ResponseEntity<>("Created new User",HttpStatus.CREATED);
	}
	
}
