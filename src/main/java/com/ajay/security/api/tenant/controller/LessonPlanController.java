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

import com.ajay.security.api.tenant.entity.LessonPlan;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.LessonPlanService;

@RestController
@RequestMapping("/lessonPlan")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonPlanController {

	@Autowired
	private LessonPlanService lessonPlanService;

	@GetMapping("/listAllLessonPlan")
	public ApiResponse getAllLessonPlan() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of LessonPlan",
					lessonPlanService.getAllLessonPlans());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"LessonPlan Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneLessonPlan(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "LessonPlan",
					lessonPlanService.getOneLessonPlan(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"LessonPlan Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveLessonPlan")
	public ApiResponse saveLessonPlan(@RequestBody LessonPlan lessonPlan) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "LessonPlan saved!",
					lessonPlanService.saveLessonPlan(lessonPlan));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"LessonPlan Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateLessonPlan")
	public ApiResponse updateLessonPlan(@RequestBody LessonPlan lessonPlan) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "LessonPlan updated!",
					lessonPlanService.saveLessonPlan(lessonPlan));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"LessonPlan Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteLessonPlan")
	public ApiResponse deleteOneLessonPlan(@RequestBody LessonPlan lessonPlan) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, lessonPlanService.deleteOneLessonPlan(lessonPlan),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"LessonPlan Service exception : " + e.getLocalizedMessage());
		}
	}
}
