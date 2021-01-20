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

import com.ajay.security.api.tenant.entity.ExamObservation;
import com.ajay.security.api.tenant.service.ExamObservationService;

@RestController
@RequestMapping("/examObservation")
public class ExamObservationController {

	@Autowired
	private ExamObservationService examObservationService;

	@GetMapping("/all")
	public List<ExamObservation> getAllExamObservation() {
		return examObservationService.getAllExamObservations();
	}

	@GetMapping("/one/{id}")
	public ExamObservation getOneExamObservation(@PathVariable Integer id) {
		return examObservationService.getOneExamObservation(id);
	}

	@PostMapping("/save")
	public String saveExamObservation(@RequestBody ExamObservation examObservation) {
		return examObservationService.saveExamObservation(examObservation);
	}

	@PutMapping("/update")
	public String updateExamObservation(@RequestBody ExamObservation examObservation) {
		return examObservationService.updateExamObservation(examObservation);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExamObservation(@PathVariable Integer id) {
		return examObservationService.deleteOneExamObservation(id);
	}
}
