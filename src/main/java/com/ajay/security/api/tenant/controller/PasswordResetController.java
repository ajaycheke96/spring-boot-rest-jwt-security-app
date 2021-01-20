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

import com.ajay.security.api.tenant.entity.PasswordReset;
import com.ajay.security.api.tenant.service.PasswordResetService;

@RestController
@RequestMapping("/passwordReset")
public class PasswordResetController {

	@Autowired
	private PasswordResetService passwordResetService;

	@GetMapping("/all")
	public List<PasswordReset> getAllPasswordReset() {
		return passwordResetService.getAllPasswordResets();
	}

	@GetMapping("/one/{email}")
	public List<PasswordReset> getOnePasswordReset(@PathVariable String email) {
		return passwordResetService.getOnePasswordReset(email);
	}

	@PostMapping("/save")
	public String savePasswordReset(@RequestBody PasswordReset passwordReset) {
		return passwordResetService.savePasswordReset(passwordReset);
	}

	@PutMapping("/update")
	public String updatePasswordReset(@RequestBody PasswordReset passwordReset) {
		return passwordResetService.updatePasswordReset(passwordReset);
	}

	@DeleteMapping("/delete")
	public String deleteOnePasswordReset(@RequestBody PasswordReset passwordReset) {
		return passwordResetService.deleteOnePasswordReset(passwordReset);
	}
}
