package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.ClassTimingSession;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ClassTimingSessionService;

@RestController
@RequestMapping("/classTimingSession")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClassTimingSessionController {

	@Autowired
	private ClassTimingSessionService classTimingSessionService;

	@GetMapping("/listAllClassTimingSessions")
	public ApiResponse getAllClassTimingSession() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ClassTimingSession",
					classTimingSessionService.getAllClassTimingSessions());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTimingSession Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneClassTimingSession(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTimingSession",
					classTimingSessionService.getOneClassTimingSession(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTimingSession Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/saveClassTimingSession")
	public ApiResponse saveClassTimingSession(@RequestBody ClassTimingSession classTimingSession) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTimingSession saved!",
					classTimingSessionService.saveClassTimingSession(classTimingSession));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTimingSession Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateClassTimingSession", method = RequestMethod.POST)
	public ApiResponse updateClassTimingSession(@RequestBody ClassTimingSession classTimingSession) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTimingSession updated!",
					classTimingSessionService.saveClassTimingSession(classTimingSession));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTimingSession Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/deleteClassTimingSession")
	public ApiResponse deleteOneClassTimingSession(@RequestBody ClassTimingSession classTimingSession) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTimingSession deleted!",
					classTimingSessionService.deleteOneClassTimingSession(classTimingSession));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTimingSession Service exception : " + e.getLocalizedMessage());
		}
	}
}
