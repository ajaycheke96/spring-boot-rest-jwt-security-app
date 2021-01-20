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

import com.ajay.security.api.tenant.entity.Religion;
import com.ajay.security.api.tenant.service.ReligionService;

@RestController
@RequestMapping("/religion")
public class ReligionController {

	@Autowired
	private ReligionService religionService;

	@GetMapping("/all")
	public List<Religion> getAllReligion() {
		return religionService.getAllReligions();
	}

	@GetMapping("/one/{id}")
	public Religion getOneReligion(@PathVariable Integer id) {
		return religionService.getOneReligion(id);
	}

	@PostMapping("/save")
	public String saveReligion(@RequestBody Religion religion) {
		return religionService.saveReligion(religion);
	}

	@PutMapping("/update")
	public String updateReligion(@RequestBody Religion religion) {
		return religionService.updateReligion(religion);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneReligion(@PathVariable Integer id) {
		return religionService.deleteOneReligion(id);
	}
}
