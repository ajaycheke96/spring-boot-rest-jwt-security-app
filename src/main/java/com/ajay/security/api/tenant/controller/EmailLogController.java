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

import com.ajay.security.api.tenant.entity.EmailLog;
import com.ajay.security.api.tenant.service.EmailLogService;

@RestController
@RequestMapping("/emailLog")
public class EmailLogController {

	@Autowired
	private EmailLogService emailLogService;

	@GetMapping("/all")
	public List<EmailLog> getAllEmailLog() {
		return emailLogService.getAllEmailLogs();
	}

	@GetMapping("/one/{id}")
	public EmailLog getOneEmailLog(@PathVariable Integer id) {
		return emailLogService.getOneEmailLog(id);
	}

	@PostMapping("/save")
	public String saveEmailLog(@RequestBody EmailLog emailLog) {
		return emailLogService.saveEmailLog(emailLog);
	}

	@PutMapping("/update")
	public String updateEmailLog(@RequestBody EmailLog emailLog) {
		return emailLogService.updateEmailLog(emailLog);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmailLog(@PathVariable Integer id) {
		return emailLogService.deleteOneEmailLog(id);
	}
}
