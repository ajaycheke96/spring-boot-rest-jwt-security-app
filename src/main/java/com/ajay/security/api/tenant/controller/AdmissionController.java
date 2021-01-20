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

import com.ajay.security.api.tenant.entity.Admission;
import com.ajay.security.api.tenant.service.AdmissionService;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

	@Autowired
	private AdmissionService admissionService;

	@GetMapping("/all")
	public List<Admission> getAllAdmission() {
		return admissionService.getAllAdmissions();
	}

	@GetMapping("/one/{id}")
	public Admission getOneAdmission(@PathVariable Integer id) {
		return admissionService.getOneAdmission(id);
	}

	@PostMapping("/save")
	public String saveAdmission(@RequestBody Admission admission) {
		return admissionService.saveAdmission(admission);
	}

	@PutMapping("/update")
	public String updateAdmission(@RequestBody Admission admission) {
		return admissionService.updateAdmission(admission);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneAdmission(@PathVariable Integer id) {
		return admissionService.deleteOneAdmission(id);
	}
}
