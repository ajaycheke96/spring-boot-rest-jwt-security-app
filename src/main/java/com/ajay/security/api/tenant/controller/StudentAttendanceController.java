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

import com.ajay.security.api.tenant.entity.StudentAttendance;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.StudentAttendanceService;

@RestController
@RequestMapping("/studentAttendance")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentAttendanceController {

	@Autowired
	private StudentAttendanceService studentAttendanceService;

	@GetMapping("/listAllStudentAttendance")
	public ApiResponse getAllStudentAttendance() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of StudentAttendance",
					studentAttendanceService.getAllStudentAttendances());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentAttendance Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneStudentAttendance(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StudentAttendance",
					studentAttendanceService.getOneStudentAttendance(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentAttendance Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveStudentAttendance")
	public ApiResponse saveStudentAttendance(@RequestBody StudentAttendance studentAttendance) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StudentAttendance saved!",
					studentAttendanceService.saveStudentAttendance(studentAttendance));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentAttendance Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateStudentAttendance")
	public ApiResponse updateStudentAttendance(@RequestBody StudentAttendance studentAttendance) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StudentAttendance updated!",
					studentAttendanceService.saveStudentAttendance(studentAttendance));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentAttendance Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteStudentAttendance")
	public ApiResponse deleteOneStudentAttendance(@RequestBody StudentAttendance studentAttendance) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					studentAttendanceService.deleteOneStudentAttendance(studentAttendance), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentAttendance Service exception : " + e.getLocalizedMessage());
		}
	}
}
