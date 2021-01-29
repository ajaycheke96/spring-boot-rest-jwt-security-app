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

	public String saveEmailLog(EmailLog emailLog) {
		Timestamp curTimestamp = new Timestamp(System.currentTimeMillis());
		emailLog.setCreatedAt(curTimestamp);
		emailLog.setUpdatedAt(curTimestamp);
		return emailLogRepository.save(emailLog) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEmailLog(EmailLog emailLog) {
		Timestamp curTimestamp = new Timestamp(System.currentTimeMillis());
		emailLog.setUpdatedAt(curTimestamp);
		return emailLogRepository.save(emailLog) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneEmailLog(Integer id) {
		emailLogRepository.deleteById(id);
		return " successfully deleted!";
	}
}
