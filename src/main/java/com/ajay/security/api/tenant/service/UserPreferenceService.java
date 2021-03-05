package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public UserPreference saveUserPreference(UserPreference userPreference) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (userPreference.getCreatedAt() == null)
			userPreference.setCreatedAt(currentTimestamp);
		userPreference.setUpdatedAt(currentTimestamp);
		return userPreferenceRepository.save(userPreference);
	}

	public String deleteOneUserPreference(UserPreference userPreference) {
		String result = null;
		if (userPreferenceRepository.existsById(userPreference.getId())) {
			userPreferenceRepository.delete(userPreference);
			result = " UserPreference deleted!";
		} else {
			result = "UserPreference Not Found! or Already deleted!";
		}
		return result;
	}
}
