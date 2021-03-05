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

import com.ajay.security.api.tenant.entity.OnlineExam;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.OnlineExamService;

@RestController
@RequestMapping("/onlineExam")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OnlineExamController {

	@Autowired
	private OnlineExamService onlineExamService;

	@GetMapping("/listAllOnlineExam")
	public ApiResponse getAllOnlineExam() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of OnlineExam",
					onlineExamService.getAllOnlineExams());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExam Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneOnlineExam(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "OnlineExam",
					onlineExamService.getOneOnlineExam(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExam Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveOnlineExam")
	public ApiResponse saveOnlineExam(@RequestBody OnlineExam onlineExam) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "OnlineExam saved!",
					onlineExamService.saveOnlineExam(onlineExam));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExam Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateOnlineExam")
	public ApiResponse updateOnlineExam(@RequestBody OnlineExam onlineExam) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "OnlineExam updated!",
					onlineExamService.saveOnlineExam(onlineExam));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExam Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteOnlineExam")
	public ApiResponse deleteOneOnlineExam(@RequestBody OnlineExam onlineExam) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, onlineExamService.deleteOneOnlineExam(onlineExam),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExam Service exception : " + e.getLocalizedMessage());
		}
	}
}
