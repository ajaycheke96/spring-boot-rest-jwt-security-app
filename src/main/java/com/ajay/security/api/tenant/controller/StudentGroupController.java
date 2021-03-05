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

import com.ajay.security.api.tenant.entity.StudentGroup;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.StudentGroupService;

@RestController
@RequestMapping("/studentGroup")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentGroupController {

	@Autowired
	private StudentGroupService studentGroupService;

	@GetMapping("/listAllStudentGroup")
	public ApiResponse getAllStudentGroup() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of StudentGroup",
					studentGroupService.getAllStudentGroups());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneStudentGroup(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StudentGroup",
					studentGroupService.getOneStudentGroup(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveStudentGroup")
	public ApiResponse saveStudentGroup(@RequestBody StudentGroup studentGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StudentGroup saved!",
					studentGroupService.saveStudentGroup(studentGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateStudentGroup")
	public ApiResponse updateStudentGroup(@RequestBody StudentGroup studentGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StudentGroup updated!",
					studentGroupService.saveStudentGroup(studentGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteStudentGroup")
	public ApiResponse deleteOneStudentGroup(@RequestBody StudentGroup studentGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					studentGroupService.deleteOneStudentGroup(studentGroup), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentGroup Service exception : " + e.getLocalizedMessage());
		}
	}
}
