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

import com.ajay.security.api.tenant.entity.Subject;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.SubjectService;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/listAllSubject")
	public ApiResponse getAllSubject() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Subject", subjectService.getAllSubjects());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Subject Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneSubject(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Subject", subjectService.getOneSubject(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Subject Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveSubject")
	public ApiResponse saveSubject(@RequestBody Subject subject) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Subject saved!",
					subjectService.saveSubject(subject));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Subject Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateSubject")
	public ApiResponse updateSubject(@RequestBody Subject subject) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Subject updated!",
					subjectService.saveSubject(subject));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Subject Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteSubject")
	public ApiResponse deleteOneSubject(@RequestBody Subject subject) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, subjectService.deleteOneSubject(subject), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Subject Service exception : " + e.getLocalizedMessage());
		}
	}
}
