package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.CallLog;
import com.ajay.security.api.tenant.entity.User;
import com.ajay.security.api.tenant.repository.CallLogRepository;
import com.ajay.security.api.tenant.repository.UserRepository;

@Service
@Transactional
public class CallLogService {

	@Autowired
	private CallLogRepository callLogRepository;

//	@Autowired
//	private UserRepository userRepository;

	public List<CallLog> getAllCallLogs() {
		return callLogRepository.findAll();
	}

	public CallLog getOneCallLog(Integer id) {
		return callLogRepository.findById(id).get();
	}

	public String saveCallLog(CallLog callLog) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		callLog.setCreatedAt(currentTimestamp);
		callLog.setUpdatedAt(currentTimestamp);

		callLog.getCallingPurpos().setCreatedAt(currentTimestamp);
		callLog.getCallingPurpos().setUpdatedAt(currentTimestamp);

		/*
		 * User user = callLog.getUser(); if (user.getId() != null) { User existedUser =
		 * userRepository.findById(user.getId()).orElseThrow();
		 * existedUser.setCallLogs(List.of(callLog)); callLog.setUser(existedUser); }
		 */

		return callLogRepository.save(callLog) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateCallLog(CallLog callLog) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		callLog.setUpdatedAt(currentTimestamp);

		callLog.getCallingPurpos().setUpdatedAt(currentTimestamp);

		return callLogRepository.save(callLog) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneCallLog(Integer id) {
		callLogRepository.deleteById(id);
		return " successfully deleted!";
	}
}
