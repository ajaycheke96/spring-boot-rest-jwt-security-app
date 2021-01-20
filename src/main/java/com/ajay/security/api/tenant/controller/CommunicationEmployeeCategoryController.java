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

import com.ajay.security.api.tenant.entity.CommunicationEmployeeCategory;
import com.ajay.security.api.tenant.service.CommunicationEmployeeCategoryService;

@RestController
@RequestMapping("/communicationEmployeeCategory")
public class CommunicationEmployeeCategoryController {

	@Autowired
	private CommunicationEmployeeCategoryService communicationEmployeeCategoryService;

	@GetMapping("/all")
	public List<CommunicationEmployeeCategory> getAllCommunicationEmployeeCategory() {
		return communicationEmployeeCategoryService.getAllCommunicationEmployeeCategorys();
	}

	@GetMapping("/one/{id}")
	public CommunicationEmployeeCategory getOneCommunicationEmployeeCategory(@PathVariable Integer id) {
		return communicationEmployeeCategoryService.getOneCommunicationEmployeeCategory(id);
	}

	@PostMapping("/save")
	public String saveCommunicationEmployeeCategory(
			@RequestBody CommunicationEmployeeCategory communicationEmployeeCategory) {
		return communicationEmployeeCategoryService.saveCommunicationEmployeeCategory(communicationEmployeeCategory);
	}

	@PutMapping("/update")
	public String updateCommunicationEmployeeCategory(
			@RequestBody CommunicationEmployeeCategory communicationEmployeeCategory) {
		return communicationEmployeeCategoryService.updateCommunicationEmployeeCategory(communicationEmployeeCategory);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCommunicationEmployeeCategory(@PathVariable Integer id) {
		return communicationEmployeeCategoryService.deleteOneCommunicationEmployeeCategory(id);
	}
}
