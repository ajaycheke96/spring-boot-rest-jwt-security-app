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

import com.ajay.security.api.tenant.entity.StudentParent;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.StudentParentService;

@RestController
@RequestMapping("/studentParent")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentParentController {

	@Autowired
	private StudentParentService studentParentService;

	@GetMapping("/listAllStudentParent")
	public ApiResponse getAllStudentParent() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of StudentParent",
					studentParentService.getAllStudentParents());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentParent Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneStudentParent(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StudentParent",
					studentParentService.getOneStudentParent(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentParent Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveStudentParent")
	public ApiResponse saveStudentParent(@RequestBody StudentParent studentParent) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StudentParent saved!",
					studentParentService.saveStudentParent(studentParent));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentParent Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateStudentParent")
	public ApiResponse updateStudentParent(@RequestBody StudentParent studentParent) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StudentParent updated!",
					studentParentService.saveStudentParent(studentParent));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentParent Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteStudentParent")
	public ApiResponse deleteOneStudentParent(@RequestBody StudentParent studentParent) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					studentParentService.deleteOneStudentParent(studentParent), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StudentParent Service exception : " + e.getLocalizedMessage());
		}
	}
}
