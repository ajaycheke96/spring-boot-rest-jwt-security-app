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

import com.ajay.security.api.tenant.entity.ExamSchedule;
import com.ajay.security.api.tenant.service.ExamScheduleService;

@RestController
@RequestMapping("/examSchedule")
public class ExamScheduleController {

	@Autowired
	private ExamScheduleService examScheduleService;

	@GetMapping("/all")
	public List<ExamSchedule> getAllExamSchedule() {
		return examScheduleService.getAllExamSchedules();
	}

	@GetMapping("/one/{id}")
	public ExamSchedule getOneExamSchedule(@PathVariable Integer id) {
		return examScheduleService.getOneExamSchedule(id);
	}

	@PostMapping("/save")
	public String saveExamSchedule(@RequestBody ExamSchedule examSchedule) {
		return examScheduleService.saveExamSchedule(examSchedule);
	}

	@PutMapping("/update")
	public String updateExamSchedule(@RequestBody ExamSchedule examSchedule) {
		return examScheduleService.updateExamSchedule(examSchedule);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExamSchedule(@PathVariable Integer id) {
		return examScheduleService.deleteOneExamSchedule(id);
	}
}
