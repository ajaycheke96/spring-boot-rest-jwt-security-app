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

import com.ajay.security.api.tenant.entity.UserPreference;
import com.ajay.security.api.tenant.service.UserPreferenceService;

@RestController
@RequestMapping("/userPreference")
public class UserPreferenceController {

	@Autowired
	private UserPreferenceService userPreferenceService;

	@GetMapping("/all")
	public List<UserPreference> getAllUserPreference() {
		return userPreferenceService.getAllUserPreferences();
	}

	@GetMapping("/one/{id}")
	public UserPreference getOneUserPreference(@PathVariable Integer id) {
		return userPreferenceService.getOneUserPreference(id);
	}

	@PostMapping("/save")
	public String saveUserPreference(@RequestBody UserPreference userPreference) {
		return userPreferenceService.saveUserPreference(userPreference);
	}

	@PutMapping("/update")
	public String updateUserPreference(@RequestBody UserPreference userPreference) {
		return userPreferenceService.updateUserPreference(userPreference);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneUserPreference(@PathVariable Integer id) {
		return userPreferenceService.deleteOneUserPreference(id);
	}
}
