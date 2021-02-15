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

import com.ajay.security.api.tenant.entity.ClassTiming;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ClassTimingService;

@RestController
@RequestMapping("/classTiming")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClassTimingController {

	@Autowired
	private ClassTimingService classTimingService;

	@RequestMapping("/listAllClassTiming")
	public ApiResponse getAllClassTiming() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ClassTiming",
					classTimingService.getAllClassTimings());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTiming Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/{id}")
	public ApiResponse getOneClassTiming(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTiming",
					classTimingService.getOneClassTiming(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTiming Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveClassTiming", method = RequestMethod.POST)
	public ApiResponse saveClassTiming(@RequestBody ClassTiming classTiming) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTiming saved!",
					classTimingService.saveClassTiming(classTiming));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTiming Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateClassTiming", method = RequestMethod.POST)
	public ApiResponse updateClassTiming(@RequestBody ClassTiming classTiming) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTiming updated!",
					classTimingService.saveClassTiming(classTiming));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTiming Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/deleteClassTiming")
	public ApiResponse deleteOneClassTiming(@RequestBody ClassTiming classTiming) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTiming deleted!",
					classTimingService.deleteOneClassTiming(classTiming));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTiming Service exception : " + e.getLocalizedMessage());
		}
	}
}
