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

import com.ajay.security.api.tenant.entity.StudentSibling;
import com.ajay.security.api.tenant.service.StudentSiblingService;

@RestController
@RequestMapping("/studentSibling")
public class StudentSiblingController {

	@Autowired
	private StudentSiblingService studentSiblingService;

	@GetMapping("/all")
	public List<StudentSibling> getAllStudentSibling() {
		return studentSiblingService.getAllStudentSiblings();
	}

	@GetMapping("/one/{id}")
	public StudentSibling getOneStudentSibling(@PathVariable Integer id) {
		return studentSiblingService.getOneStudentSibling(id);
	}

	@PostMapping("/save")
	public String saveStudentSibling(@RequestBody StudentSibling studentSibling) {
		return studentSiblingService.saveStudentSibling(studentSibling);
	}

	@PutMapping("/update")
	public String updateStudentSibling(@RequestBody StudentSibling studentSibling) {
		return studentSiblingService.updateStudentSibling(studentSibling);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentSibling(@PathVariable Integer id) {
		return studentSiblingService.deleteOneStudentSibling(id);
	}
}
