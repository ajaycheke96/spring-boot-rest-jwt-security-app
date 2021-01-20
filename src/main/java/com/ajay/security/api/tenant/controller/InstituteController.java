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

import com.ajay.security.api.tenant.entity.Institute;
import com.ajay.security.api.tenant.service.InstituteService;

@RestController
@RequestMapping("/institute")
public class InstituteController {

	@Autowired
	private InstituteService instituteService;

	@GetMapping("/all")
	public List<Institute> getAllInstitute() {
		return instituteService.getAllInstitutes();
	}

	@GetMapping("/one/{id}")
	public Institute getOneInstitute(@PathVariable Integer id) {
		return instituteService.getOneInstitute(id);
	}

	@PostMapping("/save")
	public String saveInstitute(@RequestBody Institute institute) {
		return instituteService.saveInstitute(institute);
	}

	@PutMapping("/update")
	public String updateInstitute(@RequestBody Institute institute) {
		return instituteService.updateInstitute(institute);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneInstitute(@PathVariable Integer id) {
		return instituteService.deleteOneInstitute(id);
	}
}
