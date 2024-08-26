package com.user.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User u) {
		String userId = UUID.randomUUID().toString();
		u.setUserId(userId);
		return userRepo.save(u);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		return userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with Id: "+userId+" not found!!!"));
	}

	@Override
	public User updateUser(User u) {
		return userRepo.save(u);
	}

	public void deleteUser(String userId) {
		userRepo.deleteById(userId);
	}

}
