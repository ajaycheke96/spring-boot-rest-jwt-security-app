package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentDocument;
import com.ajay.security.api.tenant.repository.StudentDocumentRepository;

@Service
@Transactional
public class StudentDocumentService {

	@Autowired
	private StudentDocumentRepository studentDocumentRepository;

	public List<StudentDocument> getAllStudentDocuments() {
		return studentDocumentRepository.findAll();
	}

	public StudentDocument getOneStudentDocument(Integer id) {
		return studentDocumentRepository.findById(id).get();
	}

	public String saveStudentDocument(StudentDocument studentDocument) {
		return studentDocumentRepository.save(studentDocument) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentDocument(StudentDocument studentDocument) {
		return studentDocumentRepository.save(studentDocument) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentDocument(Integer id) {
		studentDocumentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
