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

import com.ajay.security.api.tenant.entity.ExamObservation;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ExamObservationService;

@RestController
@RequestMapping("/examObservation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExamObservationController {

	@Autowired
	private ExamObservationService examObservationService;

	@GetMapping("/listAllExamObservation")
	public ApiResponse getAllExamObservation() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ExamObservation",
					examObservationService.getAllExamObservations());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamObservation Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneExamObservation(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamObservation",
					examObservationService.getOneExamObservation(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamObservation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveExamObservation")
	public ApiResponse saveExamObservation(@RequestBody ExamObservation examObservation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamObservation saved!",
					examObservationService.saveExamObservation(examObservation));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamObservation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateExamObservation")
	public ApiResponse updateExamObservation(@RequestBody ExamObservation examObservation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamObservation updated!",
					examObservationService.saveExamObservation(examObservation));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamObservation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteExamObservation")
	public ApiResponse deleteOneExamObservation(@RequestBody ExamObservation examObservation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					examObservationService.deleteOneExamObservation(examObservation), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamObservation Service exception : " + e.getLocalizedMessage());
		}
	}
}
