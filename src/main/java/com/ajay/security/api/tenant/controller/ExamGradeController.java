package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.ExamGrade;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ExamGradeService;

@RestController
@RequestMapping("/examGrade")
public class ExamGradeController {

	@Autowired
	private ExamGradeService examGradeService;

	@RequestMapping("/listAllExamGrade")
	public ApiResponse getAllExamGrade() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ExamGrade",
					examGradeService.getAllExamGrades());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamGrade Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/{id}")
	public ApiResponse getOneExamGrade(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamGrade", examGradeService.getOneExamGrade(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamGrade Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveExamGrade", method = RequestMethod.POST)
	public ApiResponse saveExamGrade(@RequestBody ExamGrade examGrade) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamGrade saved!",
					examGradeService.saveExamGrade(examGrade));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamGrade Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateExamGrade", method = RequestMethod.POST)
	public ApiResponse updateExamGrade(@RequestBody ExamGrade examGrade) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamGrade updated!",
					examGradeService.saveExamGrade(examGrade));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamGrade Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteExamGrade", method = RequestMethod.POST)
	public ApiResponse deleteOneExamGrade(@RequestBody ExamGrade examGrade) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamGrade deleted!",
					examGradeService.deleteOneExamGrade(examGrade));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamGrade Service exception : " + e.getLocalizedMessage());
		}
	}
}
