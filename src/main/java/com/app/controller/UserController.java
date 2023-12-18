package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.repository.UserRepo;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
    private UserRepo userRepository;
	@GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        // Implement
		return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }
 
	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable(value = "id") String id) {
	    Optional<User> user = userRepository.findById(id);
	 
	    if(user.isPresent()) {
	        return ResponseEntity.ok().body(user.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
 
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody  User user) {
        
    	return new ResponseEntity<>(userRepository.save(user),HttpStatus.OK)
    			.ok("Succesfully Saved.");
    }
}
