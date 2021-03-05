package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Student;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/listAllStudent")
	public ApiResponse getAllStudent() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Student", studentService.getAllStudents());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Student Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/{id}")
	public ApiResponse getOneStudent(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Student", studentService.getOneStudent(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Student Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ApiResponse saveStudent(@RequestBody Student student) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Student saved!",
					studentService.saveStudent(student));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Student Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public ApiResponse updateStudent(@RequestBody Student student) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Student updated!",
					studentService.saveStudent(student));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Student Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	public ApiResponse deleteOneStudent(@RequestBody Student student) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Student deleted!",
					studentService.deleteOneStudent(student));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Student Service exception : " + e.getLocalizedMessage());
		}
	}
}
