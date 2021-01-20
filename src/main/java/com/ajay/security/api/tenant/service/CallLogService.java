package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CallLog;
import com.ajay.security.api.tenant.repository.CallLogRepository;

@Service
public class CallLogService {

	@Autowired
	private CallLogRepository callLogRepository;

	public List<CallLog> getAllCallLogs() {
		return callLogRepository.findAll();
	}

	public CallLog getOneCallLog(Integer id) {
		return callLogRepository.findById(id).get();
	}

	public String saveCallLog(CallLog callLog) {
		return callLogRepository.save(callLog) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateCallLog(CallLog callLog) {
		return callLogRepository.save(callLog) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneCallLog(Integer id) {
		callLogRepository.deleteById(id);
		return " successfully deleted!";
	}
}
