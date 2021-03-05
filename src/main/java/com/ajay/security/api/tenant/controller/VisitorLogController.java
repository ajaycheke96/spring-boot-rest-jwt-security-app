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

import com.ajay.security.api.tenant.entity.VisitorLog;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VisitorLogService;

@RestController
@RequestMapping("/visitorLog")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VisitorLogController {

	@Autowired
	private VisitorLogService visitorLogService;

	@GetMapping("/listAllVisitorLog")
	public ApiResponse getAllVisitorLog() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of VisitorLog",
					visitorLogService.getAllVisitorLogs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVisitorLog(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VisitorLog",
					visitorLogService.getOneVisitorLog(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVisitorLog")
	public ApiResponse saveVisitorLog(@RequestBody VisitorLog visitorLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VisitorLog saved!",
					visitorLogService.saveVisitorLog(visitorLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVisitorLog")
	public ApiResponse updateVisitorLog(@RequestBody VisitorLog visitorLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VisitorLog updated!",
					visitorLogService.saveVisitorLog(visitorLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVisitorLog")
	public ApiResponse deleteOneVisitorLog(@RequestBody VisitorLog visitorLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, visitorLogService.deleteOneVisitorLog(visitorLog),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorLog Service exception : " + e.getLocalizedMessage());
		}
	}
}
