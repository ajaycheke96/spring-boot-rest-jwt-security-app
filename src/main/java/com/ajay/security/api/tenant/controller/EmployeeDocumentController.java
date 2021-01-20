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

import com.ajay.security.api.tenant.entity.EmployeeDocument;
import com.ajay.security.api.tenant.service.EmployeeDocumentService;

@RestController
@RequestMapping("/employeeDocument")
public class EmployeeDocumentController {

	@Autowired
	private EmployeeDocumentService employeeDocumentService;

	@GetMapping("/all")
	public List<EmployeeDocument> getAllEmployeeDocument() {
		return employeeDocumentService.getAllEmployeeDocuments();
	}

	@GetMapping("/one/{id}")
	public EmployeeDocument getOneEmployeeDocument(@PathVariable Integer id) {
		return employeeDocumentService.getOneEmployeeDocument(id);
	}

	@PostMapping("/save")
	public String saveEmployeeDocument(@RequestBody EmployeeDocument employeeDocument) {
		return employeeDocumentService.saveEmployeeDocument(employeeDocument);
	}

	@PutMapping("/update")
	public String updateEmployeeDocument(@RequestBody EmployeeDocument employeeDocument) {
		return employeeDocumentService.updateEmployeeDocument(employeeDocument);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeDocument(@PathVariable Integer id) {
		return employeeDocumentService.deleteOneEmployeeDocument(id);
	}
}
