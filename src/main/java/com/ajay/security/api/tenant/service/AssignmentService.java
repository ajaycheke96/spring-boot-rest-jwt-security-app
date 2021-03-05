package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Assignment;
import com.ajay.security.api.tenant.repository.AssignmentRepository;

@Service
@Transactional
public class AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;

	public List<Assignment> getAllAssignments() {
		return assignmentRepository.findAll();
	}

	public Assignment getOneAssignment(Integer id) {
		return assignmentRepository.findById(id).get();
	}

	public Assignment saveAssignment(Assignment assignment) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (assignment.getCreatedAt() == null)
			assignment.setCreatedAt(currentTimestamp);
		assignment.setUpdatedAt(currentTimestamp);
		return assignmentRepository.save(assignment);
	}

	public String deleteOneAssignment(Assignment assignment) {
		String result = null;
		if (assignmentRepository.existsById(assignment.getId())) {
			assignmentRepository.delete(assignment);
			result = " Assignment deleted!";
		} else {
			result = "Assignment Not Found! or Already deleted!";
		}
		return result;
	}
}
