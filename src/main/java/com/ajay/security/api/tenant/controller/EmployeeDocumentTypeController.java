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

import com.ajay.security.api.tenant.entity.EmployeeDocumentType;
import com.ajay.security.api.tenant.service.EmployeeDocumentTypeService;

@RestController
@RequestMapping("/employeeDocumentType")
public class EmployeeDocumentTypeController {

	@Autowired
	private EmployeeDocumentTypeService employeeDocumentTypeService;

	@GetMapping("/all")
	public List<EmployeeDocumentType> getAllEmployeeDocumentType() {
		return employeeDocumentTypeService.getAllEmployeeDocumentTypes();
	}

	@GetMapping("/one/{id}")
	public EmployeeDocumentType getOneEmployeeDocumentType(@PathVariable Integer id) {
		return employeeDocumentTypeService.getOneEmployeeDocumentType(id);
	}

	@PostMapping("/save")
	public String saveEmployeeDocumentType(@RequestBody EmployeeDocumentType employeeDocumentType) {
		return employeeDocumentTypeService.saveEmployeeDocumentType(employeeDocumentType);
	}

	@PutMapping("/update")
	public String updateEmployeeDocumentType(@RequestBody EmployeeDocumentType employeeDocumentType) {
		return employeeDocumentTypeService.updateEmployeeDocumentType(employeeDocumentType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeDocumentType(@PathVariable Integer id) {
		return employeeDocumentTypeService.deleteOneEmployeeDocumentType(id);
	}
}
