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

import com.ajay.security.api.tenant.entity.ComplaintType;
import com.ajay.security.api.tenant.service.ComplaintTypeService;

@RestController
@RequestMapping("/complaintType")
public class ComplaintTypeController {

	@Autowired
	private ComplaintTypeService complaintTypeService;

	@GetMapping("/all")
	public List<ComplaintType> getAllComplaintType() {
		return complaintTypeService.getAllComplaintTypes();
	}

	@GetMapping("/one/{id}")
	public ComplaintType getOneComplaintType(@PathVariable Integer id) {
		return complaintTypeService.getOneComplaintType(id);
	}

	@PostMapping("/save")
	public String saveComplaintType(@RequestBody ComplaintType complaintType) {
		return complaintTypeService.saveComplaintType(complaintType);
	}

	@PutMapping("/update")
	public String updateComplaintType(@RequestBody ComplaintType complaintType) {
		return complaintTypeService.updateComplaintType(complaintType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneComplaintType(@PathVariable Integer id) {
		return complaintTypeService.deleteOneComplaintType(id);
	}
}
