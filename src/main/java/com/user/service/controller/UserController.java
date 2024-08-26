package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/welcome")
	public ResponseEntity<?> displayMessage(){
		return new ResponseEntity<>("Welcome to userService", HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userList = userService.getAllUsers();
		return ResponseEntity.ok(userList);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User u = userService.getUser(userId);
		return ResponseEntity.ok(u);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User u){
		User user = userService.saveUser(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User u){
		User user = userService.updateUser(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}
}
