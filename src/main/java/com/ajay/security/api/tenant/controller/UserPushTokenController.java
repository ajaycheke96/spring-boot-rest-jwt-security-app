package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.UserPushToken;
import com.ajay.security.api.tenant.service.UserPushTokenService;

@RestController
@RequestMapping("/userPushToken")
public class UserPushTokenController {

	@Autowired
	private UserPushTokenService userPushTokenService;

	@GetMapping("/all")
	public List<UserPushToken> getAllUserPushToken() {
		return userPushTokenService.getAllUserPushTokens();
	}

	@GetMapping("/one/{id}")
	public UserPushToken getOneUserPushToken(@PathVariable Integer id) {
		return userPushTokenService.getOneUserPushToken(id);
	}

	@PostMapping("/save")
	public String saveUserPushToken(@RequestBody UserPushToken userPushToken) {
		return userPushTokenService.saveUserPushToken(userPushToken);
	}

	@PutMapping("/update")
	public String updateUserPushToken(@RequestBody UserPushToken userPushToken) {
		return userPushTokenService.updateUserPushToken(userPushToken);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneUserPushToken(@PathVariable Integer id) {
		return userPushTokenService.deleteOneUserPushToken(id);
	}
}
