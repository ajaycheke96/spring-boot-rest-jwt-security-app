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

import com.ajay.security.api.tenant.entity.BookLog;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.BookLogService;

@RestController
@RequestMapping("/bookLog")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookLogController {

	@Autowired
	private BookLogService bookLogService;

	@GetMapping("/listAllBookLog")
	public ApiResponse getAllBookLog() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of BookLog", bookLogService.getAllBookLogs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BookLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneBookLog(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "BookLog", bookLogService.getOneBookLog(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BookLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveBookLog")
	public ApiResponse saveBookLog(@RequestBody BookLog bookLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "BookLog saved!",
					bookLogService.saveBookLog(bookLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BookLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateBookLog")
	public ApiResponse updateBookLog(@RequestBody BookLog bookLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "BookLog updated!",
					bookLogService.saveBookLog(bookLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BookLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteBookLog")
	public ApiResponse deleteOneBookLog(@RequestBody BookLog bookLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, bookLogService.deleteOneBookLog(bookLog), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BookLog Service exception : " + e.getLocalizedMessage());
		}
	}
}
