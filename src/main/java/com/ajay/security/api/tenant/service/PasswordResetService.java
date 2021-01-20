package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.PasswordReset;
import com.ajay.security.api.tenant.repository.PasswordResetRepository;

@Service
@Transactional
public class PasswordResetService {

	@Autowired
	private PasswordResetRepository passwordResetRepository;

	public List<PasswordReset> getAllPasswordResets() {
		return passwordResetRepository.findAll();
	}

	public List<PasswordReset> getOnePasswordReset(String email) {
		return passwordResetRepository.findByEmail(email);
	}

	public String savePasswordReset(PasswordReset passwordReset) {
		return passwordResetRepository.save(passwordReset) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updatePasswordReset(PasswordReset passwordReset) {
		return passwordResetRepository.save(passwordReset) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOnePasswordReset(PasswordReset passwordReset) {
		passwordResetRepository.delete(passwordReset);
		return " successfully deleted!";
	}
}
