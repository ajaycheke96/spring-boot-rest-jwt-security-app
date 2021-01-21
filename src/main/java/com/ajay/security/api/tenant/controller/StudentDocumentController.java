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

import com.ajay.security.api.tenant.entity.StudentDocument;
import com.ajay.security.api.tenant.service.StudentDocumentService;

@RestController
@RequestMapping("/studentDocument")
public class StudentDocumentController {

	@Autowired
	private StudentDocumentService studentDocumentService;

	@GetMapping("/all")
	public List<StudentDocument> getAllStudentDocument() {
		return studentDocumentService.getAllStudentDocuments();
	}

	@GetMapping("/one/{id}")
	public StudentDocument getOneStudentDocument(@PathVariable Integer id) {
		return studentDocumentService.getOneStudentDocument(id);
	}

	@PostMapping("/save")
	public String saveStudentDocument(@RequestBody StudentDocument studentDocument) {
		return studentDocumentService.saveStudentDocument(studentDocument);
	}

	@PutMapping("/update")
	public String updateStudentDocument(@RequestBody StudentDocument studentDocument) {
		return studentDocumentService.updateStudentDocument(studentDocument);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentDocument(@PathVariable Integer id) {
		return studentDocumentService.deleteOneStudentDocument(id);
	}
}
