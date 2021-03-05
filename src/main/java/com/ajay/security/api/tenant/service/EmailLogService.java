package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.EmailLog;
import com.ajay.security.api.tenant.repository.EmailLogRepository;

@Service
public class EmailLogService {

	@Autowired
	private EmailLogRepository emailLogRepository;

	public List<EmailLog> getAllEmailLogs() {
		return emailLogRepository.findAll();
	}

	public EmailLog getOneEmailLog(Integer id) {
		return emailLogRepository.findById(id).get();
	}

	public EmailLog saveEmailLog(EmailLog emailLog) {
		Timestamp curTimestamp = new Timestamp(System.currentTimeMillis());
		if (emailLog.getCreatedAt() == null)
			emailLog.setCreatedAt(curTimestamp);
		emailLog.setUpdatedAt(curTimestamp);
		return emailLogRepository.save(emailLog);
	}

	public String deleteOneEmailLog(EmailLog emailLog) {
		String result = null;
		if (emailLogRepository.existsById(emailLog.getId())) {
			emailLogRepository.delete(emailLog);
			result = " EmailLog deleted!";
		} else {
			result = "EmailLog Not Found! or Already deleted!";
		}
		return result;
	}
}
