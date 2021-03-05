package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public VisitorLog saveVisitorLog(VisitorLog visitorLog) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (visitorLog.getCreatedAt() == null)
			visitorLog.setCreatedAt(currentTimestamp);
		visitorLog.setUpdatedAt(currentTimestamp);

		if (visitorLog.getVisitingPurpos() != null)
			if (visitorLog.getVisitingPurpos().getCreatedAt() == null)
				visitorLog.getVisitingPurpos().setCreatedAt(currentTimestamp);
		visitorLog.getVisitingPurpos().setUpdatedAt(currentTimestamp);
		return visitorLogRepository.save(visitorLog);
	}

	public String deleteOneVisitorLog(VisitorLog visitorLog) {
		String result = null;
		if (visitorLogRepository.existsById(visitorLog.getId())) {
			visitorLogRepository.delete(visitorLog);
			result = " VisitorLog deleted!";
		} else {
			result = "VisitorLog Not Found! or Already deleted!";
		}
		return result;
	}
}
