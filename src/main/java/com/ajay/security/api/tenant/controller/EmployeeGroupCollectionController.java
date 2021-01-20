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

import com.ajay.security.api.tenant.entity.EmployeeGroupCollection;
import com.ajay.security.api.tenant.service.EmployeeGroupCollectionService;

@RestController
@RequestMapping("/employeeGroupCollection")
public class EmployeeGroupCollectionController {

	@Autowired
	private EmployeeGroupCollectionService employeeGroupCollectionService;

	@GetMapping("/all")
	public List<EmployeeGroupCollection> getAllEmployeeGroupCollection() {
		return employeeGroupCollectionService.getAllEmployeeGroupCollections();
	}

	@GetMapping("/one/{id}")
	public EmployeeGroupCollection getOneEmployeeGroupCollection(@PathVariable Integer id) {
		return employeeGroupCollectionService.getOneEmployeeGroupCollection(id);
	}

	@PostMapping("/save")
	public String saveEmployeeGroupCollection(@RequestBody EmployeeGroupCollection employeeGroupCollection) {
		return employeeGroupCollectionService.saveEmployeeGroupCollection(employeeGroupCollection);
	}

	@PutMapping("/update")
	public String updateEmployeeGroupCollection(@RequestBody EmployeeGroupCollection employeeGroupCollection) {
		return employeeGroupCollectionService.updateEmployeeGroupCollection(employeeGroupCollection);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeGroupCollection(@PathVariable Integer id) {
		return employeeGroupCollectionService.deleteOneEmployeeGroupCollection(id);
	}
}
