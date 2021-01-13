package com.ajay.security.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.entity.User;
import com.ajay.security.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/all")
//	@PreAuthorize("hasRole('USER') or hasRole('EMP') or hasRole('ADMIN')")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/one/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public User getOneUser(@PathVariable Integer id) {
		return userService.getOneUser(id);
	}

	@DeleteMapping("/remove/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public String deleteOneUser(@PathVariable Integer id) {
		return userService.deleteOneUser(id);
	}

	@PostMapping("/save")
//	@PreAuthorize("hasRole('ADMIN')")
	public String saveUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userService.saveOneUser(user);
	}

	@PutMapping("/update")
//	@PreAuthorize("hasRole('ADMIN')")
	public String updateUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userService.updateOneUser(user);
	}

}
