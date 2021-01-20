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

import com.ajay.security.api.tenant.entity.CommunicationEmployee;
import com.ajay.security.api.tenant.service.CommunicationEmployeeService;

@RestController
@RequestMapping("/communicationEmployee")
public class CommunicationEmployeeController {

	@Autowired
	private CommunicationEmployeeService communicationEmployeeService;

	@GetMapping("/all")
	public List<CommunicationEmployee> getAllCommunicationEmployee() {
		return communicationEmployeeService.getAllCommunicationEmployees();
	}

	@GetMapping("/one/{id}")
	public CommunicationEmployee getOneCommunicationEmployee(@PathVariable Integer id) {
		return communicationEmployeeService.getOneCommunicationEmployee(id);
	}

	@PostMapping("/save")
	public String saveCommunicationEmployee(@RequestBody CommunicationEmployee communicationEmployee) {
		return communicationEmployeeService.saveCommunicationEmployee(communicationEmployee);
	}

	@PutMapping("/update")
	public String updateCommunicationEmployee(@RequestBody CommunicationEmployee communicationEmployee) {
		return communicationEmployeeService.updateCommunicationEmployee(communicationEmployee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCommunicationEmployee(@PathVariable Integer id) {
		return communicationEmployeeService.deleteOneCommunicationEmployee(id);
	}
}
