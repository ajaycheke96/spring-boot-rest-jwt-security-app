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

import com.ajay.security.api.tenant.entity.CallLog;
import com.ajay.security.api.tenant.service.CallLogService;

@RestController
@RequestMapping("/callLog")
public class CallLogController {

	@Autowired
	private CallLogService callLogService;

	@GetMapping("/all")
	public List<CallLog> getAllCallLog() {
		return callLogService.getAllCallLogs();
	}

	@GetMapping("/one/{id}")
	public CallLog getOneCallLog(@PathVariable Integer id) {
		return callLogService.getOneCallLog(id);
	}

	@PostMapping("/save")
	public String saveCallLog(@RequestBody CallLog callLog) {
		return callLogService.saveCallLog(callLog);
	}

	@PutMapping("/update")
	public String updateCallLog(@RequestBody CallLog callLog) {
		return callLogService.updateCallLog(callLog);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCallLog(@PathVariable Integer id) {
		return callLogService.deleteOneCallLog(id);
	}
}
