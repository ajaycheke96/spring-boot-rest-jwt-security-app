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

import com.ajay.security.api.tenant.entity.StudentDocumentType;
import com.ajay.security.api.tenant.service.StudentDocumentTypeService;

@RestController
@RequestMapping("/studentDocumentType")
public class StudentDocumentTypeController {

	@Autowired
	private StudentDocumentTypeService studentDocumentTypeService;

	@GetMapping("/all")
	public List<StudentDocumentType> getAllStudentDocumentType() {
		return studentDocumentTypeService.getAllStudentDocumentTypes();
	}

	@GetMapping("/one/{id}")
	public StudentDocumentType getOneStudentDocumentType(@PathVariable Integer id) {
		return studentDocumentTypeService.getOneStudentDocumentType(id);
	}

	@PostMapping("/save")
	public String saveStudentDocumentType(@RequestBody StudentDocumentType studentDocumentType) {
		return studentDocumentTypeService.saveStudentDocumentType(studentDocumentType);
	}

	@PutMapping("/update")
	public String updateStudentDocumentType(@RequestBody StudentDocumentType studentDocumentType) {
		return studentDocumentTypeService.updateStudentDocumentType(studentDocumentType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentDocumentType(@PathVariable Integer id) {
		return studentDocumentTypeService.deleteOneStudentDocumentType(id);
	}
}
