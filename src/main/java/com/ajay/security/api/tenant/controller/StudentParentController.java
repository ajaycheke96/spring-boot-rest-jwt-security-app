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

import com.ajay.security.api.tenant.entity.StudentParent;
import com.ajay.security.api.tenant.service.StudentParentService;

@RestController
@RequestMapping("/studentParent")
public class StudentParentController {

	@Autowired
	private StudentParentService studentParentService;

	@GetMapping("/all")
	public List<StudentParent> getAllStudentParent() {
		return studentParentService.getAllStudentParents();
	}

	@GetMapping("/one/{id}")
	public StudentParent getOneStudentParent(@PathVariable Integer id) {
		return studentParentService.getOneStudentParent(id);
	}

	@PostMapping("/save")
	public String saveStudentParent(@RequestBody StudentParent studentParent) {
		return studentParentService.saveStudentParent(studentParent);
	}

	@PutMapping("/update")
	public String updateStudentParent(@RequestBody StudentParent studentParent) {
		return studentParentService.updateStudentParent(studentParent);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentParent(@PathVariable Integer id) {
		return studentParentService.deleteOneStudentParent(id);
	}
}
