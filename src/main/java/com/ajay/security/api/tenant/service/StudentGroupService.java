package com.ajay.security.api.tenant.service;

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

	public String saveStudentGroup(StudentGroup studentGroup) {
		return studentGroupRepository.save(studentGroup) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentGroup(StudentGroup studentGroup) {
		return studentGroupRepository.save(studentGroup) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentGroup(Integer id) {
		studentGroupRepository.deleteById(id);
		return " successfully deleted!";
	}
}
