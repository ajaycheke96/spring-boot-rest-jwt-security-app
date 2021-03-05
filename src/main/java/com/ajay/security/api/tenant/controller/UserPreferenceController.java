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

import com.ajay.security.api.tenant.entity.UserPreference;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.UserPreferenceService;

@RestController
@RequestMapping("/userPreference")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserPreferenceController {

	@Autowired
	private UserPreferenceService userPreferenceService;

	@GetMapping("/listAllUserPreference")
	public ApiResponse getAllUserPreference() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of UserPreference",
					userPreferenceService.getAllUserPreferences());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPreference Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneUserPreference(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "UserPreference",
					userPreferenceService.getOneUserPreference(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPreference Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveUserPreference")
	public ApiResponse saveUserPreference(@RequestBody UserPreference userPreference) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "UserPreference saved!",
					userPreferenceService.saveUserPreference(userPreference));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPreference Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateUserPreference")
	public ApiResponse updateUserPreference(@RequestBody UserPreference userPreference) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "UserPreference updated!",
					userPreferenceService.saveUserPreference(userPreference));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPreference Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteUserPreference")
	public ApiResponse deleteOneUserPreference(@RequestBody UserPreference userPreference) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					userPreferenceService.deleteOneUserPreference(userPreference), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"UserPreference Service exception : " + e.getLocalizedMessage());
		}
	}
}
