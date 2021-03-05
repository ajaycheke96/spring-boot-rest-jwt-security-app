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

import com.ajay.security.api.tenant.entity.ClassTeacher;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ClassTeacherService;

@RestController
@RequestMapping("/classTeacher")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClassTeacherController {

	@Autowired
	private ClassTeacherService classTeacherService;

	@GetMapping("/listAllClassTeacher")
	public ApiResponse getAllClassTeacher() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ClassTeacher",
					classTeacherService.getAllClassTeachers());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTeacher Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneClassTeacher(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTeacher",
					classTeacherService.getOneClassTeacher(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTeacher Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveClassTeacher")
	public ApiResponse saveClassTeacher(@RequestBody ClassTeacher classTeacher) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTeacher saved!",
					classTeacherService.saveClassTeacher(classTeacher));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTeacher Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateClassTeacher")
	public ApiResponse updateClassTeacher(@RequestBody ClassTeacher classTeacher) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ClassTeacher updated!",
					classTeacherService.saveClassTeacher(classTeacher));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTeacher Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteClassTeacher")
	public ApiResponse deleteOneClassTeacher(@RequestBody ClassTeacher classTeacher) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					classTeacherService.deleteOneClassTeacher(classTeacher), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ClassTeacher Service exception : " + e.getLocalizedMessage());
		}
	}
}
