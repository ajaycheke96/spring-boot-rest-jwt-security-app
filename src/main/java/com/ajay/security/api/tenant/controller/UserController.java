package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.User;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/listAllUser")
//	@PreAuthorize("hasRole('USER') or hasRole('EMP') or hasRole('ADMIN')")
	public ApiResponse getAllUsers() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of User", userService.getAllUsers());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"User Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ApiResponse getOneUser(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "User", userService.getOneUser(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"User Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteUser")
//	@PreAuthorize("hasRole('ADMIN')")
	public ApiResponse deleteOneUser(@RequestBody User user) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, userService.deleteOneUser(user), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"User Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveUser")
//	@PreAuthorize("hasRole('ADMIN')")
	public ApiResponse saveUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "User saved", userService.saveOneUser(user));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"User Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateUser")
//	@PreAuthorize("hasRole('ADMIN')")
	public ApiResponse updateUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "User updated", userService.saveOneUser(user));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"User Service exception : " + e.getLocalizedMessage());
		}
	}

}
