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

import com.ajay.security.api.tenant.entity.CommunicationDepartment;
import com.ajay.security.api.tenant.service.CommunicationDepartmentService;

@RestController
@RequestMapping("/communicationDepartment")
public class CommunicationDepartmentController {

	@Autowired
	private CommunicationDepartmentService communicationDepartmentService;

	@GetMapping("/all")
	public List<CommunicationDepartment> getAllCommunicationDepartment() {
		return communicationDepartmentService.getAllCommunicationDepartments();
	}

	@GetMapping("/one/{id}")
	public CommunicationDepartment getOneCommunicationDepartment(@PathVariable Integer id) {
		return communicationDepartmentService.getOneCommunicationDepartment(id);
	}

	@PostMapping("/save")
	public String saveCommunicationDepartment(@RequestBody CommunicationDepartment communicationDepartment) {
		return communicationDepartmentService.saveCommunicationDepartment(communicationDepartment);
	}

	@PutMapping("/update")
	public String updateCommunicationDepartment(@RequestBody CommunicationDepartment communicationDepartment) {
		return communicationDepartmentService.updateCommunicationDepartment(communicationDepartment);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCommunicationDepartment(@PathVariable Integer id) {
		return communicationDepartmentService.deleteOneCommunicationDepartment(id);
	}
}
