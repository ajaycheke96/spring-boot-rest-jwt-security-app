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

import com.ajay.security.api.tenant.entity.Syllabus;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.SyllabusService;

@RestController
@RequestMapping("/syllabus")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SyllabusController {

	@Autowired
	private SyllabusService syllabusService;

	@GetMapping("/listAllSyllabus")
	public ApiResponse getAllSyllabus() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Syllabus",
					syllabusService.getAllSyllabuss());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Syllabus Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneSyllabus(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Syllabus", syllabusService.getOneSyllabus(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Syllabus Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveSyllabus")
	public ApiResponse saveSyllabus(@RequestBody Syllabus syllabus) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Syllabus saved!",
					syllabusService.saveSyllabus(syllabus));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Syllabus Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateSyllabus")
	public ApiResponse updateSyllabus(@RequestBody Syllabus syllabus) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Syllabus updated!",
					syllabusService.saveSyllabus(syllabus));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Syllabus Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteSyllabus")
	public ApiResponse deleteOneSyllabus(@RequestBody Syllabus syllabus) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, syllabusService.deleteOneSyllabus(syllabus), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Syllabus Service exception : " + e.getLocalizedMessage());
		}
	}
}
