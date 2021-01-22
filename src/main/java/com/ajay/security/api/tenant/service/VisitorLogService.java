package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VisitorLog;
import com.ajay.security.api.tenant.repository.VisitorLogRepository;

@Service
@Transactional
public class VisitorLogService {

	@Autowired
	private VisitorLogRepository visitorLogRepository;

	public List<VisitorLog> getAllVisitorLogs() {
		return visitorLogRepository.findAll();
	}

	public VisitorLog getOneVisitorLog(Integer id) {
		return visitorLogRepository.findById(id).get();
	}

	public String saveVisitorLog(VisitorLog visitorLog) {
		return visitorLogRepository.save(visitorLog) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateVisitorLog(VisitorLog visitorLog) {
		return visitorLogRepository.save(visitorLog) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneVisitorLog(Integer id) {
		visitorLogRepository.deleteById(id);
		return " successfully deleted!";
	}
}
