package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public PasswordReset savePasswordReset(PasswordReset passwordReset) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (passwordReset.getCreatedAt() == null)
			passwordReset.setCreatedAt(currentTimestamp);
		return passwordResetRepository.save(passwordReset);
	}

	public String deleteOnePasswordReset(PasswordReset passwordReset) {
		String result = null;
		if (passwordResetRepository.existsById(passwordReset.getEmail())) {
			passwordResetRepository.delete(passwordReset);
			result = " PasswordReset deleted!";
		} else {
			result = "PasswordReset Not Found! or Already deleted!";
		}
		return result;
	}
}
