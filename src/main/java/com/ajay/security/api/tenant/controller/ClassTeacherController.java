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

import com.ajay.security.api.tenant.entity.ClassTeacher;
import com.ajay.security.api.tenant.service.ClassTeacherService;

@RestController
@RequestMapping("/classTeacher")
public class ClassTeacherController {

	@Autowired
	private ClassTeacherService classTeacherService;

	@GetMapping("/all")
	public List<ClassTeacher> getAllClassTeacher() {
		return classTeacherService.getAllClassTeachers();
	}

	@GetMapping("/one/{id}")
	public ClassTeacher getOneClassTeacher(@PathVariable Integer id) {
		return classTeacherService.getOneClassTeacher(id);
	}

	@PostMapping("/save")
	public String saveClassTeacher(@RequestBody ClassTeacher classTeacher) {
		return classTeacherService.saveClassTeacher(classTeacher);
	}

	@PutMapping("/update")
	public String updateClassTeacher(@RequestBody ClassTeacher classTeacher) {
		return classTeacherService.updateClassTeacher(classTeacher);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneClassTeacher(@PathVariable Integer id) {
		return classTeacherService.deleteOneClassTeacher(id);
	}
}
