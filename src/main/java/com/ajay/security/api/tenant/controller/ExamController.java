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

import com.ajay.security.api.tenant.entity.Exam;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ExamService;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExamController {

	@Autowired
	private ExamService examService;

	@RequestMapping("/listAllExam")
	public ApiResponse getAllExam() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "List of Exam", examService.getAllExams());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exam Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/{id}")
	public ApiResponse getOneExam(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Exam", examService.getOneExam(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exam Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveExam", method = RequestMethod.POST)
	public ApiResponse saveExam(@RequestBody Exam exam) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Exam saved!", examService.saveExam(exam));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exam Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateExam", method = RequestMethod.POST)
	public ApiResponse updateExam(@RequestBody Exam exam) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Exam updated!", examService.saveExam(exam));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exam Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteExam", method = RequestMethod.POST)
	public ApiResponse deleteOneExam(@RequestBody Exam exam) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, examService.deleteOneExam(exam), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exam Service exception : " + e.getLocalizedMessage());
		}
	}
}
