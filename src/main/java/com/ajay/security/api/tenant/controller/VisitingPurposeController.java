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

import com.ajay.security.api.tenant.entity.VisitingPurpose;
import com.ajay.security.api.tenant.service.VisitingPurposeService;

@RestController
@RequestMapping("/visitingPurpose")
public class VisitingPurposeController {

	@Autowired
	private VisitingPurposeService visitingPurposeService;

	@GetMapping("/all")
	public List<VisitingPurpose> getAllVisitingPurpose() {
		return visitingPurposeService.getAllVisitingPurposes();
	}

	@GetMapping("/one/{id}")
	public VisitingPurpose getOneVisitingPurpose(@PathVariable Integer id) {
		return visitingPurposeService.getOneVisitingPurpose(id);
	}

	@PostMapping("/save")
	public String saveVisitingPurpose(@RequestBody VisitingPurpose visitingPurpose) {
		return visitingPurposeService.saveVisitingPurpose(visitingPurpose);
	}

	@PutMapping("/update")
	public String updateVisitingPurpose(@RequestBody VisitingPurpose visitingPurpose) {
		return visitingPurposeService.updateVisitingPurpose(visitingPurpose);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVisitingPurpose(@PathVariable Integer id) {
		return visitingPurposeService.deleteOneVisitingPurpose(id);
	}
}
