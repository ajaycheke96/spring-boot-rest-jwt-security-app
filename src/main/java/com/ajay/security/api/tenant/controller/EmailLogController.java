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

import com.ajay.security.api.tenant.entity.EmailLog;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmailLogService;

@RestController
@RequestMapping("/emailLog")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmailLogController {

	@Autowired
	private EmailLogService emailLogService;

	@GetMapping("/listAllEmailLog")
	public ApiResponse getAllEmailLog() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmailLog",
					emailLogService.getAllEmailLogs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmailLog(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmailLog", emailLogService.getOneEmailLog(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmailLog")
	public ApiResponse saveEmailLog(@RequestBody EmailLog emailLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmailLog saved!",
					emailLogService.saveEmailLog(emailLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmailLog")
	public ApiResponse updateEmailLog(@RequestBody EmailLog emailLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmailLog updated!",
					emailLogService.saveEmailLog(emailLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmailLog")
	public ApiResponse deleteOneEmailLog(@RequestBody EmailLog emailLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, emailLogService.deleteOneEmailLog(emailLog), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailLog Service exception : " + e.getLocalizedMessage());
		}
	}
}
