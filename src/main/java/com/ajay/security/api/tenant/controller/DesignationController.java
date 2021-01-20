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

import com.ajay.security.api.tenant.entity.Designation;
import com.ajay.security.api.tenant.service.DesignationService;

@RestController
@RequestMapping("/designation")
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@GetMapping("/all")
	public List<Designation> getAllDesignation() {
		return designationService.getAllDesignations();
	}

	@GetMapping("/one/{id}")
	public Designation getOneDesignation(@PathVariable Integer id) {
		return designationService.getOneDesignation(id);
	}

	@PostMapping("/save")
	public String saveDesignation(@RequestBody Designation designation) {
		return designationService.saveDesignation(designation);
	}

	@PutMapping("/update")
	public String updateDesignation(@RequestBody Designation designation) {
		return designationService.updateDesignation(designation);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneDesignation(@PathVariable Integer id) {
		return designationService.deleteOneDesignation(id);
	}
}
