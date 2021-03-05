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

import com.ajay.security.api.tenant.entity.PasswordReset;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.PasswordResetService;

@RestController
@RequestMapping("/passwordReset")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PasswordResetController {

	@Autowired
	private PasswordResetService passwordResetService;

	@GetMapping("/listAllPasswordReset")
	public ApiResponse getAllPasswordReset() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of PasswordReset",
					passwordResetService.getAllPasswordResets());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PasswordReset Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{email}")
	public ApiResponse getOnePasswordReset(@PathVariable String email) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PasswordReset",
					passwordResetService.getOnePasswordReset(email));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PasswordReset Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/savePasswordReset")
	public ApiResponse savePasswordReset(@RequestBody PasswordReset passwordReset) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PasswordReset saved!",
					passwordResetService.savePasswordReset(passwordReset));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PasswordReset Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updatePasswordReset")
	public ApiResponse updatePasswordReset(@RequestBody PasswordReset passwordReset) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PasswordReset updated!",
					passwordResetService.savePasswordReset(passwordReset));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PasswordReset Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deletePasswordReset")
	public ApiResponse deleteOnePasswordReset(@RequestBody PasswordReset passwordReset) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					passwordResetService.deleteOnePasswordReset(passwordReset), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PasswordReset Service exception : " + e.getLocalizedMessage());
		}
	}
}
