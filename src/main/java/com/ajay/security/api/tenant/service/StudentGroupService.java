package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentGroup;
import com.ajay.security.api.tenant.repository.StudentGroupRepository;

@Service
@Transactional
public class StudentGroupService {

	@Autowired
	private StudentGroupRepository studentGroupRepository;

	public List<StudentGroup> getAllStudentGroups() {
		return studentGroupRepository.findAll();
	}

	public StudentGroup getOneStudentGroup(Integer id) {
		return studentGroupRepository.findById(id).get();
	}

	public StudentGroup saveStudentGroup(StudentGroup studentGroup) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (studentGroup.getCreatedAt() == null)
			studentGroup.setCreatedAt(currentTimestamp);
		studentGroup.setUpdatedAt(currentTimestamp);
		return studentGroupRepository.save(studentGroup);
	}

	public String deleteOneStudentGroup(StudentGroup studentGroup) {
		String result = null;
		if (studentGroupRepository.existsById(studentGroup.getId())) {
			studentGroupRepository.delete(studentGroup);
			result = " StudentGroup deleted!";
		} else {
			result = "StudentGroup Not Found! or Already deleted!";
		}
		return result;
	}
}
