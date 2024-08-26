package com.user.service.services;

import java.util.List;

import com.user.service.entities.User;

public interface UserService {

	User saveUser(User u);
	
	List<User> getAllUsers();
	
	User getUser(String userId);
	
	User updateUser(User u);
	
	void deleteUser(String userId);
}
