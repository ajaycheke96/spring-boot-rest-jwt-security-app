package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.UserPushToken;
import com.ajay.security.api.tenant.repository.UserPushTokenRepository;

@Service
@Transactional
public class UserPushTokenService {

	@Autowired
	private UserPushTokenRepository userPushTokenRepository;

	public List<UserPushToken> getAllUserPushTokens() {
		return userPushTokenRepository.findAll();
	}

	public UserPushToken getOneUserPushToken(Integer id) {
		return userPushTokenRepository.findById(id).get();
	}

	public UserPushToken saveUserPushToken(UserPushToken userPushToken) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (userPushToken.getCreatedAt() == null)
			userPushToken.setCreatedAt(currentTimestamp);
		userPushToken.setUpdatedAt(currentTimestamp);
		return userPushTokenRepository.save(userPushToken);
	}

	public String deleteOneUserPushToken(UserPushToken userPushToken) {
		String result = null;
		if (userPushTokenRepository.existsById(userPushToken.getId())) {
			userPushTokenRepository.delete(userPushToken);
			result = " UserPushToken deleted!";
		} else {
			result = "UserPushToken Not Found! or Already deleted!";
		}
		return result;
	}
}
