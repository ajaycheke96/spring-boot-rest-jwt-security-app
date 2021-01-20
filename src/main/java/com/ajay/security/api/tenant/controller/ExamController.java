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

import com.ajay.security.api.tenant.entity.Exam;
import com.ajay.security.api.tenant.service.ExamService;

@RestController
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	private ExamService examService;

	@GetMapping("/all")
	public List<Exam> getAllExam() {
		return examService.getAllExams();
	}

	@GetMapping("/one/{id}")
	public Exam getOneExam(@PathVariable Integer id) {
		return examService.getOneExam(id);
	}

	@PostMapping("/save")
	public String saveExam(@RequestBody Exam exam) {
		return examService.saveExam(exam);
	}

	@PutMapping("/update")
	public String updateExam(@RequestBody Exam exam) {
		return examService.updateExam(exam);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExam(@PathVariable Integer id) {
		return examService.deleteOneExam(id);
	}
}
