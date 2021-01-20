package com.ajay.security.api.tenant.service;

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

	public String saveActivityLog(ActivityLog activityLog) {
		return activityLogRepository.save(activityLog) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateActivityLog(ActivityLog activityLog) {
		return activityLogRepository.save(activityLog) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneActivityLog(Integer id) {
		activityLogRepository.deleteById(id);
		return " successfully deleted!";
	}
}
