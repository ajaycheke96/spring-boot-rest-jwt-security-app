package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.AcademicSession;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.AcademicSessionService;

@RestController
@RequestMapping("/academicSession")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AcademicSessionController {

	@Autowired
	private AcademicSessionService academicSessionService;

	@RequestMapping("/listAllAcademicSessions")
	public ApiResponse getAllAcademicSessions() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of AcademicSession",
					academicSessionService.getAllAcademicSessions());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"AcademicSession Service exception : " + e.getLocalizedMessage());
		}

	}

	@RequestMapping("/{id}")
	public ApiResponse getOneAcademicSession(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "AcademicSession",
					academicSessionService.getOneAcademicSession(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"AcademicSession Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveAcademicSession")
	public ApiResponse saveAcademicSession(@RequestBody AcademicSession academicSession) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "AcademicSession saved!",
					academicSessionService.saveAcademicSession(academicSession));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"AcademicSession Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/updateAcademicSession")
	public ApiResponse updateAcademicSession(@RequestBody AcademicSession academicSession) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "AcademicSession updated!",
					academicSessionService.updateAcademicSession(academicSession));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"AcademicSession Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/removeAcademicSession/{id}", method = RequestMethod.POST)
	public ApiResponse deleteOneAcademicSession(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "AcademicSession deleted!",
					academicSessionService.deleteOneAcademicSession(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"AcademicSession Service exception : " + e.getLocalizedMessage());
		}
	}
}
