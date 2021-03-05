package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.SubjectTeacher;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.SubjectTeacherService;

@RestController
@RequestMapping("/subjectTeacher")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubjectTeacherController {

	@Autowired
	private SubjectTeacherService subjectTeacherService;

	@GetMapping("/listAllSubjectTeacher")
	public ApiResponse getAllSubjectTeacher() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of SubjectTeacher",
					subjectTeacherService.getAllSubjectTeachers());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"SubjectTeacher Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneSubjectTeacher(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "SubjectTeacher",
					subjectTeacherService.getOneSubjectTeacher(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"SubjectTeacher Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveSubjectTeacher")
	public ApiResponse saveSubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "SubjectTeacher saved!",
					subjectTeacherService.saveSubjectTeacher(subjectTeacher));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"SubjectTeacher Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateSubjectTeacher")
	public ApiResponse updateSubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "SubjectTeacher updated!",
					subjectTeacherService.saveSubjectTeacher(subjectTeacher));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"SubjectTeacher Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteSubjectTeacher")
	public ApiResponse deleteOneSubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					subjectTeacherService.deleteOneSubjectTeacher(subjectTeacher), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"SubjectTeacher Service exception : " + e.getLocalizedMessage());
		}
	}
}
