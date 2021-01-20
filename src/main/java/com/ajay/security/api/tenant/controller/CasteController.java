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

import com.ajay.security.api.tenant.entity.Caste;
import com.ajay.security.api.tenant.service.CasteService;

@RestController
@RequestMapping("/caste")
public class CasteController {

	@Autowired
	private CasteService casteService;

	@GetMapping("/all")
	public List<Caste> getAllCaste() {
		return casteService.getAllCastes();
	}

	@GetMapping("/one/{id}")
	public Caste getOneCaste(@PathVariable Integer id) {
		return casteService.getOneCaste(id);
	}

	@PostMapping("/save")
	public String saveCaste(@RequestBody Caste caste) {
		return casteService.saveCaste(caste);
	}

	@PutMapping("/update")
	public String updateCaste(@RequestBody Caste caste) {
		return casteService.updateCaste(caste);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCaste(@PathVariable Integer id) {
		return casteService.deleteOneCaste(id);
	}
}
