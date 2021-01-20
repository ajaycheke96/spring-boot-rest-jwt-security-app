package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.ExamAssessment;
import com.ajay.security.api.tenant.service.ExamAssessmentService;

@RestController
@RequestMapping("/examAssessment")
public class ExamAssessmentController {

	@Autowired
	private ExamAssessmentService examAssessmentService;

	@GetMapping("/all")
	public List<ExamAssessment> getAllExamAssessment() {
		return examAssessmentService.getAllExamAssessments();
	}

	@GetMapping("/one/{id}")
	public ExamAssessment getOneExamAssessment(@PathVariable Integer id) {
		return examAssessmentService.getOneExamAssessment(id);
	}

	@PostMapping("/save")
	public String saveExamAssessment(@RequestBody ExamAssessment examAssessment) {
		return examAssessmentService.saveExamAssessment(examAssessment);
	}

	@PutMapping("/update")
	public String updateExamAssessment(@RequestBody ExamAssessment examAssessment) {
		return examAssessmentService.updateExamAssessment(examAssessment);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExamAssessment(@PathVariable Integer id) {
		return examAssessmentService.deleteOneExamAssessment(id);
	}
}
