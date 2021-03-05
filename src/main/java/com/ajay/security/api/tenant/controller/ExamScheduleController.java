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

import com.ajay.security.api.tenant.entity.ExamSchedule;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ExamScheduleService;

@RestController
@RequestMapping("/examSchedule")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExamScheduleController {

	@Autowired
	private ExamScheduleService examScheduleService;

	@RequestMapping(value = "/listAllExamSchedule")
	public ApiResponse getAllExamSchedule() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ExamSchedule",
					examScheduleService.getAllExamSchedules());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamSchedule Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/{id}")
	public ApiResponse getOneExamSchedule(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamSchedule",
					examScheduleService.getOneExamSchedule(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamSchedule Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveExamSchedule", method = RequestMethod.POST)
	public ApiResponse saveExamSchedule(@RequestBody ExamSchedule examSchedule) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamSchedule saved!",
					examScheduleService.saveExamSchedule(examSchedule));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamSchedule Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateExamSchedule", method = RequestMethod.POST)
	public ApiResponse updateExamSchedule(@RequestBody ExamSchedule examSchedule) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamSchedule updated!",
					examScheduleService.saveExamSchedule(examSchedule));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamSchedule Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteExamSchedule", method = RequestMethod.POST)
	public ApiResponse deleteOneExamSchedule(@RequestBody ExamSchedule examSchedule) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					examScheduleService.deleteOneExamSchedule(examSchedule), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamSchedule Service exception : " + e.getLocalizedMessage());
		}
	}
}
