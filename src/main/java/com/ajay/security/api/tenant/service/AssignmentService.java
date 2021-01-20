package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Assignment;
import com.ajay.security.api.tenant.repository.AssignmentRepository;

@Service
public class AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;

	public List<Assignment> getAllAssignments() {
		return assignmentRepository.findAll();
	}

	public Assignment getOneAssignment(Integer id) {
		return assignmentRepository.findById(id).get();
	}

	public String saveAssignment(Assignment assignment) {
		return assignmentRepository.save(assignment) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateAssignment(Assignment assignment) {
		return assignmentRepository.save(assignment) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneAssignment(Integer id) {
		assignmentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
