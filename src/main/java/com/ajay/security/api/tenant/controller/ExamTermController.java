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

import com.ajay.security.api.tenant.entity.ExamTerm;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ExamTermService;

@RestController
@RequestMapping("/examTerm")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExamTermController {

	@Autowired
	private ExamTermService examTermService;

	@RequestMapping("/listAllExamTerm")
	public ApiResponse getAllExamTerm() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "List of ExamTerm",
					examTermService.getAllExamTerms());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamTerm Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/{id}")
	public ApiResponse getOneExamTerm(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamTerm", examTermService.getOneExamTerm(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamTerm Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveExamTerm", method = RequestMethod.POST)
	public ApiResponse saveExamTerm(@RequestBody ExamTerm examTerm) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamTerm saved!",
					examTermService.saveExamTerm(examTerm));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamTerm Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateExamTerm", method = RequestMethod.POST)
	public ApiResponse updateExamTerm(@RequestBody ExamTerm examTerm) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamTerm updated!",
					examTermService.saveExamTerm(examTerm));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamTerm Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteExamTerm", method = RequestMethod.POST)
	public ApiResponse deleteOneExamTerm(@RequestBody ExamTerm examTerm) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, examTermService.deleteOneExamTerm(examTerm), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamTerm Service exception : " + e.getLocalizedMessage());
		}
	}
}
