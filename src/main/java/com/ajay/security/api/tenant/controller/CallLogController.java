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

import com.ajay.security.api.tenant.entity.CallLog;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.CallLogService;

@RestController
@RequestMapping("/callLog")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CallLogController {

	@Autowired
	private CallLogService callLogService;

	@GetMapping("/listAllCallLog")
	public ApiResponse getAllCallLog() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of CallLog", callLogService.getAllCallLogs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CallLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneCallLog(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "CallLog", callLogService.getOneCallLog(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CallLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveCallLog")
	public ApiResponse saveCallLog(@RequestBody CallLog callLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "CallLog saved!",
					callLogService.saveCallLog(callLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CallLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateCallLog")
	public ApiResponse updateCallLog(@RequestBody CallLog callLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "CallLog updated!",
					callLogService.saveCallLog(callLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CallLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteCallLog")
	public ApiResponse deleteOneCallLog(@RequestBody CallLog callLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, callLogService.deleteOneCallLog(callLog), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CallLog Service exception : " + e.getLocalizedMessage());
		}
	}
}
