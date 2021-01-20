package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.ActivityLog;
import com.ajay.security.api.tenant.service.ActivityLogService;

@RestController
@RequestMapping("/activityLog")
public class ActivityLogController {

	@Autowired
	private ActivityLogService activityLogService;

	@GetMapping("/all")
	public List<ActivityLog> getAllActivityLog() {
		return activityLogService.getAllActivityLogs();
	}

	@GetMapping("/one/{id}")
	public ActivityLog getOneActivityLog(@PathVariable Integer id) {
		return activityLogService.getOneActivityLog(id);
	}

	@PostMapping("/save")
	public String saveActivityLog(@RequestBody ActivityLog activityLog) {
		return activityLogService.saveActivityLog(activityLog);
	}

	@PutMapping("/update")
	public String updateActivityLog(@RequestBody ActivityLog activityLog) {
		return activityLogService.updateActivityLog(activityLog);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneActivityLog(@PathVariable Integer id) {
		return activityLogService.deleteOneActivityLog(id);
	}
}
