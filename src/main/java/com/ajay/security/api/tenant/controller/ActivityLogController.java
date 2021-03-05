package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.ActivityLog;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ActivityLogService;

@RestController
@RequestMapping("/activityLog")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ActivityLogController {

	@Autowired
	private ActivityLogService activityLogService;

	@GetMapping("/listAllActivityLog")
	public ApiResponse getAllActivityLog() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ActivityLog",
					activityLogService.getAllActivityLogs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ActivityLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneActivityLog(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ActivityLog",
					activityLogService.getOneActivityLog(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ActivityLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveActivityLog")
	public ApiResponse saveActivityLog(@RequestBody ActivityLog activityLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ActivityLog saved!",
					activityLogService.saveActivityLog(activityLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ActivityLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateActivityLog")
	public ApiResponse updateActivityLog(@RequestBody ActivityLog activityLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ActivityLog updated!",
					activityLogService.saveActivityLog(activityLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ActivityLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteActivityLog")
	public ApiResponse deleteOneActivityLog(@RequestBody ActivityLog activityLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, activityLogService.deleteOneActivityLog(activityLog),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ActivityLog Service exception : " + e.getLocalizedMessage());
		}
	}
}
