package com.ajay.security.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.entity.User;
import com.ajay.security.api.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getOneUser(Integer id) {
		return userRepository.findById(id).get();
	}

	public String saveOneUser(User user) {
		return userRepository.save(user).getId() != null ? "User saved successfully" : "Failed! Please try again!!";
	}

	public String deleteOneUser(Integer id) {
		userRepository.deleteById(id);
		return "User deleted successfully";
	}

	public String updateOneUser(User user) {
		userRepository.save(user);
		return "User updated successfully";
	}
}
