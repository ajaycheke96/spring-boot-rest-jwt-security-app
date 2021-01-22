package com.ajay.security.api.tenant.service;

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

	public String saveUserPushToken(UserPushToken userPushToken) {
		return userPushTokenRepository.save(userPushToken) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateUserPushToken(UserPushToken userPushToken) {
		return userPushTokenRepository.save(userPushToken) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneUserPushToken(Integer id) {
		userPushTokenRepository.deleteById(id);
		return " successfully deleted!";
	}
}
