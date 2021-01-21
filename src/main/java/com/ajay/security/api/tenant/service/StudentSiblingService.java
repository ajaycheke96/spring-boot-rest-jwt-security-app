package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentSibling;
import com.ajay.security.api.tenant.repository.StudentSiblingRepository;

@Service
@Transactional
public class StudentSiblingService {

	@Autowired
	private StudentSiblingRepository studentSiblingRepository;

	public List<StudentSibling> getAllStudentSiblings() {
		return studentSiblingRepository.findAll();
	}

	public StudentSibling getOneStudentSibling(Integer id) {
		return studentSiblingRepository.findById(id).get();
	}

	public String saveStudentSibling(StudentSibling studentSibling) {
		return studentSiblingRepository.save(studentSibling) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentSibling(StudentSibling studentSibling) {
		return studentSiblingRepository.save(studentSibling) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentSibling(Integer id) {
		studentSiblingRepository.deleteById(id);
		return " successfully deleted!";
	}
}
