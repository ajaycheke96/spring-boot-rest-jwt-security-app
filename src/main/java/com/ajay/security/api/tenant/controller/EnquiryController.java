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

import com.ajay.security.api.tenant.entity.Enquiry;
import com.ajay.security.api.tenant.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@GetMapping("/all")
	public List<Enquiry> getAllEnquiry() {
		return enquiryService.getAllEnquirys();
	}

	@GetMapping("/one/{id}")
	public Enquiry getOneEnquiry(@PathVariable Integer id) {
		return enquiryService.getOneEnquiry(id);
	}

	@PostMapping("/save")
	public String saveEnquiry(@RequestBody Enquiry enquiry) {
		return enquiryService.saveEnquiry(enquiry);
	}

	@PutMapping("/update")
	public String updateEnquiry(@RequestBody Enquiry enquiry) {
		return enquiryService.updateEnquiry(enquiry);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEnquiry(@PathVariable Integer id) {
		return enquiryService.deleteOneEnquiry(id);
	}
}
