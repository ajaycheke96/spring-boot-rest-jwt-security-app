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

import com.ajay.security.api.tenant.entity.StudentAttendance;
import com.ajay.security.api.tenant.service.StudentAttendanceService;

@RestController
@RequestMapping("/studentAttendance")
public class StudentAttendanceController {

	@Autowired
	private StudentAttendanceService studentAttendanceService;

	@GetMapping("/all")
	public List<StudentAttendance> getAllStudentAttendance() {
		return studentAttendanceService.getAllStudentAttendances();
	}

	@GetMapping("/one/{id}")
	public StudentAttendance getOneStudentAttendance(@PathVariable Integer id) {
		return studentAttendanceService.getOneStudentAttendance(id);
	}

	@PostMapping("/save")
	public String saveStudentAttendance(@RequestBody StudentAttendance studentAttendance) {
		return studentAttendanceService.saveStudentAttendance(studentAttendance);
	}

	@PutMapping("/update")
	public String updateStudentAttendance(@RequestBody StudentAttendance studentAttendance) {
		return studentAttendanceService.updateStudentAttendance(studentAttendance);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentAttendance(@PathVariable Integer id) {
		return studentAttendanceService.deleteOneStudentAttendance(id);
	}
}
