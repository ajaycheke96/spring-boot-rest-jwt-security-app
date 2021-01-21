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

import com.ajay.security.api.tenant.entity.TelescopeMonitoring;
import com.ajay.security.api.tenant.service.TelescopeMonitoringService;

@RestController
@RequestMapping("/telescopeMonitoring")
public class TelescopeMonitoringController {

	@Autowired
	private TelescopeMonitoringService telescopeMonitoringService;

	@GetMapping("/all")
	public List<TelescopeMonitoring> getAllTelescopeMonitoring() {
		return telescopeMonitoringService.getAllTelescopeMonitorings();
	}

	@GetMapping("/one/{tag}")
	public TelescopeMonitoring getOneTelescopeMonitoring(@PathVariable String tag) {
		return telescopeMonitoringService.getOneTelescopeMonitoring(tag);
	}

	@PostMapping("/save")
	public String saveTelescopeMonitoring(@RequestBody TelescopeMonitoring telescopeMonitoring) {
		return telescopeMonitoringService.saveTelescopeMonitoring(telescopeMonitoring);
	}

	@PutMapping("/update")
	public String updateTelescopeMonitoring(@RequestBody TelescopeMonitoring telescopeMonitoring) {
		return telescopeMonitoringService.updateTelescopeMonitoring(telescopeMonitoring);
	}

	@DeleteMapping("/delete")
	public String deleteOneTelescopeMonitoring(@RequestBody TelescopeMonitoring telescopeMonitoring) {
		return telescopeMonitoringService.deleteOneTelescopeMonitoring(telescopeMonitoring);
	}
}
