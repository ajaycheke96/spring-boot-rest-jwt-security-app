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

import com.ajay.security.api.tenant.entity.ExamAssessmentDetail;
import com.ajay.security.api.tenant.service.ExamAssessmentDetailService;

@RestController
@RequestMapping("/examAssessmentDetail")
public class ExamAssessmentDetailController {

	@Autowired
	private ExamAssessmentDetailService examAssessmentDetailService;

	@GetMapping("/all")
	public List<ExamAssessmentDetail> getAllExamAssessmentDetail() {
		return examAssessmentDetailService.getAllExamAssessmentDetails();
	}

	@GetMapping("/one/{id}")
	public ExamAssessmentDetail getOneExamAssessmentDetail(@PathVariable Integer id) {
		return examAssessmentDetailService.getOneExamAssessmentDetail(id);
	}

	@PostMapping("/save")
	public String saveExamAssessmentDetail(@RequestBody ExamAssessmentDetail examAssessmentDetail) {
		return examAssessmentDetailService.saveExamAssessmentDetail(examAssessmentDetail);
	}

	@PutMapping("/update")
	public String updateExamAssessmentDetail(@RequestBody ExamAssessmentDetail examAssessmentDetail) {
		return examAssessmentDetailService.updateExamAssessmentDetail(examAssessmentDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExamAssessmentDetail(@PathVariable Integer id) {
		return examAssessmentDetailService.deleteOneExamAssessmentDetail(id);
	}
}
