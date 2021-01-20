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

import com.ajay.security.api.tenant.entity.ExamTerm;
import com.ajay.security.api.tenant.service.ExamTermService;

@RestController
@RequestMapping("/examTerm")
public class ExamTermController {

	@Autowired
	private ExamTermService examTermService;

	@GetMapping("/all")
	public List<ExamTerm> getAllExamTerm() {
		return examTermService.getAllExamTerms();
	}

	@GetMapping("/one/{id}")
	public ExamTerm getOneExamTerm(@PathVariable Integer id) {
		return examTermService.getOneExamTerm(id);
	}

	@PostMapping("/save")
	public String saveExamTerm(@RequestBody ExamTerm examTerm) {
		return examTermService.saveExamTerm(examTerm);
	}

	@PutMapping("/update")
	public String updateExamTerm(@RequestBody ExamTerm examTerm) {
		return examTermService.updateExamTerm(examTerm);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExamTerm(@PathVariable Integer id) {
		return examTermService.deleteOneExamTerm(id);
	}
}
