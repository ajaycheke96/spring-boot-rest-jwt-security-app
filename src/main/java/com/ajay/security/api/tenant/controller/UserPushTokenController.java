package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.UserPushToken;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.UserPushTokenService;

@RestController
@RequestMapping("/userPushToken")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserPushTokenController {

	@Autowired
	private UserPushTokenService userPushTokenService;

	@GetMapping("/listAllUserPushToken")
	public ApiResponse getAllUserPushToken() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of UserPushToken",
					userPushTokenService.getAllUserPushTokens());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPushToken Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneUserPushToken(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "UserPushToken",
					userPushTokenService.getOneUserPushToken(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPushToken Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveUserPushToken")
	public ApiResponse saveUserPushToken(@RequestBody UserPushToken userPushToken) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "UserPushToken saved!",
					userPushTokenService.saveUserPushToken(userPushToken));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPushToken Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateUserPushToken")
	public ApiResponse updateUserPushToken(@RequestBody UserPushToken userPushToken) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "UserPushToken updated!",
					userPushTokenService.saveUserPushToken(userPushToken));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPushToken Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteUserPushToken")
	public ApiResponse deleteOneUserPushToken(@RequestBody UserPushToken userPushToken) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					userPushTokenService.deleteOneUserPushToken(userPushToken), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPushToken Service exception : " + e.getLocalizedMessage());
		}
	}
}
