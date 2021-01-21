package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentDocumentType;
import com.ajay.security.api.tenant.repository.StudentDocumentTypeRepository;

@Service
@Transactional
public class StudentDocumentTypeService {

	@Autowired
	private StudentDocumentTypeRepository studentDocumentTypeRepository;

	public List<StudentDocumentType> getAllStudentDocumentTypes() {
		return studentDocumentTypeRepository.findAll();
	}

	public StudentDocumentType getOneStudentDocumentType(Integer id) {
		return studentDocumentTypeRepository.findById(id).get();
	}

	public String saveStudentDocumentType(StudentDocumentType studentDocumentType) {
		return studentDocumentTypeRepository.save(studentDocumentType) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentDocumentType(StudentDocumentType studentDocumentType) {
		return studentDocumentTypeRepository.save(studentDocumentType) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentDocumentType(Integer id) {
		studentDocumentTypeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
