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

import com.ajay.security.api.tenant.entity.ExamGradeDetail;
import com.ajay.security.api.tenant.service.ExamGradeDetailService;

@RestController
@RequestMapping("/examGradeDetail")
public class ExamGradeDetailController {

	@Autowired
	private ExamGradeDetailService examGradeDetailService;

	@GetMapping("/all")
	public List<ExamGradeDetail> getAllExamGradeDetail() {
		return examGradeDetailService.getAllExamGradeDetails();
	}

	@GetMapping("/one/{id}")
	public ExamGradeDetail getOneExamGradeDetail(@PathVariable Integer id) {
		return examGradeDetailService.getOneExamGradeDetail(id);
	}

	@PostMapping("/save")
	public String saveExamGradeDetail(@RequestBody ExamGradeDetail examGradeDetail) {
		return examGradeDetailService.saveExamGradeDetail(examGradeDetail);
	}

	@PutMapping("/update")
	public String updateExamGradeDetail(@RequestBody ExamGradeDetail examGradeDetail) {
		return examGradeDetailService.updateExamGradeDetail(examGradeDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExamGradeDetail(@PathVariable Integer id) {
		return examGradeDetailService.deleteOneExamGradeDetail(id);
	}
}
