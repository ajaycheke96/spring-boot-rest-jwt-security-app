package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.User;
import com.ajay.security.api.tenant.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getOneUser(Integer id) {
		return userRepository.findById(id).get();
	}

	public String saveOneUser(User user) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (user.getCreatedAt() == null)
			user.setCreatedAt(currentTimestamp);
		user.setUpdatedAt(currentTimestamp);

//		// For backups list
//		if (!user.getBackups().isEmpty())
//			user.getBackups().forEach(backup -> {
//				if (backup.getCreatedAt() == null)
//					backup.setCreatedAt(currentTimestamp);
//				backup.setUpdatedAt(currentTimestamp);
//
//				backup.setUser(user);
//			});

		// For postalRecords list
		if (!user.getPostalRecords().isEmpty())
			user.getPostalRecords().forEach(postalRecord -> {
				if (postalRecord.getCreatedAt() == null)
					postalRecord.setCreatedAt(currentTimestamp);
				postalRecord.setUpdatedAt(currentTimestamp);

				postalRecord.setUser(user);
			});

		// For uploads list
		if (!user.getUploads().isEmpty())
			user.getUploads().forEach(upload -> {
				if (upload.getCreatedAt() == null)
					upload.setCreatedAt(currentTimestamp);
				upload.setUpdatedAt(currentTimestamp);

				upload.setUser(user);
			});

//		// For userPreferences list
//		if (!user.getUserPreferences().isEmpty())
//			user.getUserPreferences().forEach(userPreference -> {
//				if (userPreference.getCreatedAt() == null)
//					userPreference.setCreatedAt(currentTimestamp);
//				userPreference.setUpdatedAt(currentTimestamp);
//
//				userPreference.setUser(user);
//			});

//		// For userPushTokens list
//		if (!user.getUserPushTokens().isEmpty())
//			user.getUserPushTokens().forEach(userPushToken -> {
//				if (userPushToken.getCreatedAt() == null)
//					userPushToken.setCreatedAt(currentTimestamp);
//				userPushToken.setUpdatedAt(currentTimestamp);
//
//				userPushToken.setUser(user);
//			});

		return userRepository.save(user).getId() != null ? "SUCCESS" : "Failed! Please try again!!";
	}

	public String deleteOneUser(User user) {
		String result = null;
		if (userRepository.existsById(user.getId())) {
			userRepository.delete(user);
			result = " User deleted!";
		} else {
			result = "User Not Found! or Already deleted!";
		}
		return result;
	}
}
