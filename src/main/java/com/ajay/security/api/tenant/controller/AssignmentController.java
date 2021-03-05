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

import com.ajay.security.api.tenant.entity.Assignment;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.AssignmentService;

@RestController
@RequestMapping("/assignment")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@GetMapping("/listAllAssignment")
	public ApiResponse getAllAssignment() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Assignment",
					assignmentService.getAllAssignments());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Assignment Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneAssignment(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Assignment",
					assignmentService.getOneAssignment(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Assignment Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveAssignment")
	public ApiResponse saveAssignment(@RequestBody Assignment assignment) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Assignment saved!",
					assignmentService.saveAssignment(assignment));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Assignment Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateAssignment")
	public ApiResponse updateAssignment(@RequestBody Assignment assignment) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Assignment updated!",
					assignmentService.saveAssignment(assignment));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Assignment Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteAssignment")
	public ApiResponse deleteOneAssignment(@RequestBody Assignment assignment) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, assignmentService.deleteOneAssignment(assignment),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Assignment Service exception : " + e.getLocalizedMessage());
		}
	}

}
