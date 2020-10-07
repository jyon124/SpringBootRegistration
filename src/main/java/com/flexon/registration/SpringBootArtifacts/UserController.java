package com.flexon.registration.SpringBootArtifacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.stream.Optional;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(path="/jpa/users")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@PostMapping(path="/jpa/addNewUser")
	public ResponseEntity<String> addNewUser(@RequestBody User newUser){
		userRepo.save(newUser);
		return new ResponseEntity<>("Created new User",HttpStatus.CREATED);
	}
	
	@PutMapping(path="/jpa/updateUserPw/{id}")
	public java.util.Optional<Object> changePassword(@RequestBody User newUser, @PathVariable Long id) {
    return userRepo.findById(id)
    	      .map(user -> {
    	        user.setPassword(newUser.getPassword());
    	        return userRepo.save(user);
    	      });
	}
    
	@DeleteMapping(path="/jpa/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userRepo.deleteById(id);
		return new ResponseEntity<>("User ID:" + id + "has been deleted.",HttpStatus.ACCEPTED);
	}
}
