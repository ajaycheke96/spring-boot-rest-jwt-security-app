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

import com.ajay.security.api.tenant.entity.TelescopeMonitoring;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TelescopeMonitoringService;

@RestController
@RequestMapping("/telescopeMonitoring")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TelescopeMonitoringController {

	@Autowired
	private TelescopeMonitoringService telescopeMonitoringService;

	@GetMapping("/listAllTelescopeMonitoring")
	public ApiResponse getAllTelescopeMonitoring() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of TelescopeMonitoring",
					telescopeMonitoringService.getAllTelescopeMonitorings());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeMonitoring Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{tag}")
	public ApiResponse getOneTelescopeMonitoring(@PathVariable String tag) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TelescopeMonitoring",
					telescopeMonitoringService.getOneTelescopeMonitoring(tag));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeMonitoring Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTelescopeMonitoring")
	public ApiResponse saveTelescopeMonitoring(@RequestBody TelescopeMonitoring telescopeMonitoring) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TelescopeMonitoring saved!",
					telescopeMonitoringService.saveTelescopeMonitoring(telescopeMonitoring));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeMonitoring Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTelescopeMonitoring")
	public ApiResponse updateTelescopeMonitoring(@RequestBody TelescopeMonitoring telescopeMonitoring) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TelescopeMonitoring updated!",
					telescopeMonitoringService.saveTelescopeMonitoring(telescopeMonitoring));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeMonitoring Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTelescopeMonitoring")
	public ApiResponse deleteOneTelescopeMonitoring(@RequestBody TelescopeMonitoring telescopeMonitoring) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					telescopeMonitoringService.deleteOneTelescopeMonitoring(telescopeMonitoring), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeMonitoring Service exception : " + e.getLocalizedMessage());
		}
	}
}
