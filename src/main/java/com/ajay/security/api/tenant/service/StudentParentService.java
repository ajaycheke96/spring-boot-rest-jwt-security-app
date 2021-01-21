package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentParent;
import com.ajay.security.api.tenant.repository.StudentParentRepository;

@Service
@Transactional
public class StudentParentService {

	@Autowired
	private StudentParentRepository studentParentRepository;

	public List<StudentParent> getAllStudentParents() {
		return studentParentRepository.findAll();
	}

	public StudentParent getOneStudentParent(Integer id) {
		return studentParentRepository.findById(id).get();
	}

	public String saveStudentParent(StudentParent studentParent) {
		return studentParentRepository.save(studentParent) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentParent(StudentParent studentParent) {
		return studentParentRepository.save(studentParent) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentParent(Integer id) {
		studentParentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
