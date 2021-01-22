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

import com.ajay.security.api.tenant.entity.VisitorLog;
import com.ajay.security.api.tenant.service.VisitorLogService;

@RestController
@RequestMapping("/visitorLog")
public class VisitorLogController {

	@Autowired
	private VisitorLogService visitorLogService;

	@GetMapping("/all")
	public List<VisitorLog> getAllVisitorLog() {
		return visitorLogService.getAllVisitorLogs();
	}

	@GetMapping("/one/{id}")
	public VisitorLog getOneVisitorLog(@PathVariable Integer id) {
		return visitorLogService.getOneVisitorLog(id);
	}

	@PostMapping("/save")
	public String saveVisitorLog(@RequestBody VisitorLog visitorLog) {
		return visitorLogService.saveVisitorLog(visitorLog);
	}

	@PutMapping("/update")
	public String updateVisitorLog(@RequestBody VisitorLog visitorLog) {
		return visitorLogService.updateVisitorLog(visitorLog);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVisitorLog(@PathVariable Integer id) {
		return visitorLogService.deleteOneVisitorLog(id);
	}
}
