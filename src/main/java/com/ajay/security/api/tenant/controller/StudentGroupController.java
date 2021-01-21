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

import com.ajay.security.api.tenant.entity.StudentGroup;
import com.ajay.security.api.tenant.service.StudentGroupService;

@RestController
@RequestMapping("/studentGroup")
public class StudentGroupController {

	@Autowired
	private StudentGroupService studentGroupService;

	@GetMapping("/all")
	public List<StudentGroup> getAllStudentGroup() {
		return studentGroupService.getAllStudentGroups();
	}

	@GetMapping("/one/{id}")
	public StudentGroup getOneStudentGroup(@PathVariable Integer id) {
		return studentGroupService.getOneStudentGroup(id);
	}

	@PostMapping("/save")
	public String saveStudentGroup(@RequestBody StudentGroup studentGroup) {
		return studentGroupService.saveStudentGroup(studentGroup);
	}

	@PutMapping("/update")
	public String updateStudentGroup(@RequestBody StudentGroup studentGroup) {
		return studentGroupService.updateStudentGroup(studentGroup);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentGroup(@PathVariable Integer id) {
		return studentGroupService.deleteOneStudentGroup(id);
	}
}
