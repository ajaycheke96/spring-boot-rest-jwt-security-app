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

import com.ajay.security.api.tenant.entity.ExamGrade;
import com.ajay.security.api.tenant.service.ExamGradeService;

@RestController
@RequestMapping("/examGrade")
public class ExamGradeController {

	@Autowired
	private ExamGradeService examGradeService;

	@GetMapping("/all")
	public List<ExamGrade> getAllExamGrade() {
		return examGradeService.getAllExamGrades();
	}

	@GetMapping("/one/{id}")
	public ExamGrade getOneExamGrade(@PathVariable Integer id) {
		return examGradeService.getOneExamGrade(id);
	}

	@PostMapping("/save")
	public String saveExamGrade(@RequestBody ExamGrade examGrade) {
		return examGradeService.saveExamGrade(examGrade);
	}

	@PutMapping("/update")
	public String updateExamGrade(@RequestBody ExamGrade examGrade) {
		return examGradeService.updateExamGrade(examGrade);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExamGrade(@PathVariable Integer id) {
		return examGradeService.deleteOneExamGrade(id);
	}
}
