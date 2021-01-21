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

import com.ajay.security.api.tenant.entity.StudentQualification;
import com.ajay.security.api.tenant.service.StudentQualificationService;

@RestController
@RequestMapping("/studentQualification")
public class StudentQualificationController {

	@Autowired
	private StudentQualificationService studentQualificationService;

	@GetMapping("/all")
	public List<StudentQualification> getAllStudentQualification() {
		return studentQualificationService.getAllStudentQualifications();
	}

	@GetMapping("/one/{id}")
	public StudentQualification getOneStudentQualification(@PathVariable Integer id) {
		return studentQualificationService.getOneStudentQualification(id);
	}

	@PostMapping("/save")
	public String saveStudentQualification(@RequestBody StudentQualification studentQualification) {
		return studentQualificationService.saveStudentQualification(studentQualification);
	}

	@PutMapping("/update")
	public String updateStudentQualification(@RequestBody StudentQualification studentQualification) {
		return studentQualificationService.updateStudentQualification(studentQualification);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentQualification(@PathVariable Integer id) {
		return studentQualificationService.deleteOneStudentQualification(id);
	}
}
