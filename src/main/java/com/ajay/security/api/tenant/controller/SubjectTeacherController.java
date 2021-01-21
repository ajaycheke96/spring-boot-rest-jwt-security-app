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

import com.ajay.security.api.tenant.entity.SubjectTeacher;
import com.ajay.security.api.tenant.service.SubjectTeacherService;

@RestController
@RequestMapping("/subjectTeacher")
public class SubjectTeacherController {

	@Autowired
	private SubjectTeacherService subjectTeacherService;

	@GetMapping("/all")
	public List<SubjectTeacher> getAllSubjectTeacher() {
		return subjectTeacherService.getAllSubjectTeachers();
	}

	@GetMapping("/one/{id}")
	public SubjectTeacher getOneSubjectTeacher(@PathVariable Integer id) {
		return subjectTeacherService.getOneSubjectTeacher(id);
	}

	@PostMapping("/save")
	public String saveSubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		return subjectTeacherService.saveSubjectTeacher(subjectTeacher);
	}

	@PutMapping("/update")
	public String updateSubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		return subjectTeacherService.updateSubjectTeacher(subjectTeacher);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneSubjectTeacher(@PathVariable Integer id) {
		return subjectTeacherService.deleteOneSubjectTeacher(id);
	}
}
