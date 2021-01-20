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

import com.ajay.security.api.tenant.entity.BloodGroup;
import com.ajay.security.api.tenant.service.BloodGroupService;

@RestController
@RequestMapping("/bloodGroup")
public class BloodGroupController {

	@Autowired
	private BloodGroupService bloodGroupService;

	@GetMapping("/all")
	public List<BloodGroup> getAllBloodGroup() {
		return bloodGroupService.getAllBloodGroups();
	}

	@GetMapping("/one/{id}")
	public BloodGroup getOneBloodGroup(@PathVariable Integer id) {
		return bloodGroupService.getOneBloodGroup(id);
	}

	@PostMapping("/save")
	public String saveBloodGroup(@RequestBody BloodGroup bloodGroup) {
		return bloodGroupService.saveBloodGroup(bloodGroup);
	}

	@PutMapping("/update")
	public String updateBloodGroup(@RequestBody BloodGroup bloodGroup) {
		return bloodGroupService.updateBloodGroup(bloodGroup);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBloodGroup(@PathVariable Integer id) {
		return bloodGroupService.deleteOneBloodGroup(id);
	}
}
