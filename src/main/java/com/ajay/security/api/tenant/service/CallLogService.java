package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.CallLog;
import com.ajay.security.api.tenant.repository.CallLogRepository;

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

	public CallLog saveCallLog(CallLog callLog) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (callLog.getCreatedAt() == null)
			callLog.setCreatedAt(currentTimestamp);
		callLog.setUpdatedAt(currentTimestamp);

		if (callLog.getCallingPurpos().getCreatedAt() == null)
			callLog.getCallingPurpos().setCreatedAt(currentTimestamp);
		callLog.getCallingPurpos().setUpdatedAt(currentTimestamp);

		return callLogRepository.save(callLog);
	}

	public String deleteOneCallLog(CallLog callLog) {
		String result = null;
		if (callLogRepository.existsById(callLog.getId())) {
			callLogRepository.delete(callLog);
			result = " CallLog deleted!";
		} else {
			result = "CallLog Not Found! or Already deleted!";
		}
		return result;
	}
}
