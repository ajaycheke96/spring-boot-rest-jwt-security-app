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

import com.ajay.security.api.tenant.entity.Timetable;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TimetableService;

@RestController
@RequestMapping("/timetable")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TimetableController {

	@Autowired
	private TimetableService timetableService;

	@GetMapping("/listAllTimetable")
	public ApiResponse getAllTimetable() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Timetable",
					timetableService.getAllTimetables());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Timetable Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTimetable(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Timetable", timetableService.getOneTimetable(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Timetable Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTimetable")
	public ApiResponse saveTimetable(@RequestBody Timetable timetable) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Timetable saved!",
					timetableService.saveTimetable(timetable));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Timetable Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTimetable")
	public ApiResponse updateTimetable(@RequestBody Timetable timetable) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Timetable updated!",
					timetableService.saveTimetable(timetable));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Timetable Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTimetable")
	public ApiResponse deleteOneTimetable(@RequestBody Timetable timetable) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, timetableService.deleteOneTimetable(timetable),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Timetable Service exception : " + e.getLocalizedMessage());
		}
	}
}
