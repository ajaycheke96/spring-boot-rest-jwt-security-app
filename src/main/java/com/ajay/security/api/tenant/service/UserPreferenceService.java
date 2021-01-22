package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.UserPreference;
import com.ajay.security.api.tenant.repository.UserPreferenceRepository;

@Service
@Transactional
public class UserPreferenceService {

	@Autowired
	private UserPreferenceRepository userPreferenceRepository;

	public List<UserPreference> getAllUserPreferences() {
		return userPreferenceRepository.findAll();
	}

	public UserPreference getOneUserPreference(Integer id) {
		return userPreferenceRepository.findById(id).get();
	}

	public String saveUserPreference(UserPreference userPreference) {
		return userPreferenceRepository.save(userPreference) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateUserPreference(UserPreference userPreference) {
		return userPreferenceRepository.save(userPreference) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneUserPreference(Integer id) {
		userPreferenceRepository.deleteById(id);
		return " successfully deleted!";
	}
}
