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

import com.ajay.security.api.tenant.entity.Student;
import com.ajay.security.api.tenant.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/all")
	public List<Student> getAllStudent() {
		return studentService.getAllStudents();
	}

	@GetMapping("/one/{id}")
	public Student getOneStudent(@PathVariable Integer id) {
		return studentService.getOneStudent(id);
	}

	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudent(@PathVariable Integer id) {
		return studentService.deleteOneStudent(id);
	}
}
