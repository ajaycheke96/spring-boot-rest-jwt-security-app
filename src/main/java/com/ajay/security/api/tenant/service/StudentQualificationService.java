package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentQualification;
import com.ajay.security.api.tenant.repository.StudentQualificationRepository;

@Service
@Transactional
public class StudentQualificationService {

	@Autowired
	private StudentQualificationRepository studentQualificationRepository;

	public List<StudentQualification> getAllStudentQualifications() {
		return studentQualificationRepository.findAll();
	}

	public StudentQualification getOneStudentQualification(Integer id) {
		return studentQualificationRepository.findById(id).get();
	}

	public String saveStudentQualification(StudentQualification studentQualification) {
		return studentQualificationRepository.save(studentQualification) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentQualification(StudentQualification studentQualification) {
		return studentQualificationRepository.save(studentQualification) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentQualification(Integer id) {
		studentQualificationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
