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

import com.ajay.security.api.tenant.entity.ExamObservationDetail;
import com.ajay.security.api.tenant.service.ExamObservationDetailService;

@RestController
@RequestMapping("/examObservationDetail")
public class ExamObservationDetailController {

	@Autowired
	private ExamObservationDetailService examObservationDetailService;

	@GetMapping("/all")
	public List<ExamObservationDetail> getAllExamObservationDetail() {
		return examObservationDetailService.getAllExamObservationDetails();
	}

	@GetMapping("/one/{id}")
	public ExamObservationDetail getOneExamObservationDetail(@PathVariable Integer id) {
		return examObservationDetailService.getOneExamObservationDetail(id);
	}

	@PostMapping("/save")
	public String saveExamObservationDetail(@RequestBody ExamObservationDetail examObservationDetail) {
		return examObservationDetailService.saveExamObservationDetail(examObservationDetail);
	}

	@PutMapping("/update")
	public String updateExamObservationDetail(@RequestBody ExamObservationDetail examObservationDetail) {
		return examObservationDetailService.updateExamObservationDetail(examObservationDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExamObservationDetail(@PathVariable Integer id) {
		return examObservationDetailService.deleteOneExamObservationDetail(id);
	}
}
