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

import com.ajay.security.api.tenant.entity.Subject;
import com.ajay.security.api.tenant.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/all")
	public List<Subject> getAllSubject() {
		return subjectService.getAllSubjects();
	}

	@GetMapping("/one/{id}")
	public Subject getOneSubject(@PathVariable Integer id) {
		return subjectService.getOneSubject(id);
	}

	@PostMapping("/save")
	public String saveSubject(@RequestBody Subject subject) {
		return subjectService.saveSubject(subject);
	}

	@PutMapping("/update")
	public String updateSubject(@RequestBody Subject subject) {
		return subjectService.updateSubject(subject);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneSubject(@PathVariable Integer id) {
		return subjectService.deleteOneSubject(id);
	}
}
