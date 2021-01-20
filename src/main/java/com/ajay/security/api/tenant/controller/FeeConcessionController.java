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

import com.ajay.security.api.tenant.entity.FeeConcession;
import com.ajay.security.api.tenant.service.FeeConcessionService;

@RestController
@RequestMapping("/feeConcession")
public class FeeConcessionController {

	@Autowired
	private FeeConcessionService feeConcessionService;

	@GetMapping("/all")
	public List<FeeConcession> getAllFeeConcession() {
		return feeConcessionService.getAllFeeConcessions();
	}

	@GetMapping("/one/{id}")
	public FeeConcession getOneFeeConcession(@PathVariable Integer id) {
		return feeConcessionService.getOneFeeConcession(id);
	}

	@PostMapping("/save")
	public String saveFeeConcession(@RequestBody FeeConcession feeConcession) {
		return feeConcessionService.saveFeeConcession(feeConcession);
	}

	@PutMapping("/update")
	public String updateFeeConcession(@RequestBody FeeConcession feeConcession) {
		return feeConcessionService.updateFeeConcession(feeConcession);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFeeConcession(@PathVariable Integer id) {
		return feeConcessionService.deleteOneFeeConcession(id);
	}
}
