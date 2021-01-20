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

import com.ajay.security.api.tenant.entity.Assignment;
import com.ajay.security.api.tenant.service.AssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@GetMapping("/all")
	public List<Assignment> getAllAssignment() {
		return assignmentService.getAllAssignments();
	}

	@GetMapping("/one/{id}")
	public Assignment getOneAssignment(@PathVariable Integer id) {
		return assignmentService.getOneAssignment(id);
	}

	@PostMapping("/save")
	public String saveAssignment(@RequestBody Assignment assignment) {
		return assignmentService.saveAssignment(assignment);
	}

	@PutMapping("/update")
	public String updateAssignment(@RequestBody Assignment assignment) {
		return assignmentService.updateAssignment(assignment);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneAssignment(@PathVariable Integer id) {
		return assignmentService.deleteOneAssignment(id);
	}

}
