package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.ActivityLog;
import com.ajay.security.api.tenant.repository.ActivityLogRepository;


@Service
public class ActivityLogService {

	@Autowired
	private ActivityLogRepository activityLogRepository;

	public List<ActivityLog> getAllActivityLogs() {
		return activityLogRepository.findAll();
	}

	public ActivityLog getOneActivityLog(Integer id) {
		return activityLogRepository.findById(id).get();
	}

	/**
	 * Save Activity Log
	 * @param activityLog {@link ActivityLog}
	 * @return message {@link String}
	 */
	public String saveActivityLog(ActivityLog activityLog) {		
		Timestamp currDate = new Timestamp(System.currentTimeMillis());
		activityLog.setCreatedAt(currDate);
		activityLog.setUpdatedAt(currDate);
		return activityLogRepository.save(activityLog) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateActivityLog(ActivityLog activityLog) {
		Timestamp currDate = new Timestamp(System.currentTimeMillis());
		activityLog.setUpdatedAt(currDate);
		return activityLogRepository.save(activityLog) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneActivityLog(Integer id) {
		activityLogRepository.deleteById(id);
		return " successfully deleted!";
	}
}
