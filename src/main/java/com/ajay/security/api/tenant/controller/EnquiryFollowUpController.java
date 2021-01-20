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

import com.ajay.security.api.tenant.entity.EnquiryFollowUp;
import com.ajay.security.api.tenant.service.EnquiryFollowUpService;

@RestController
@RequestMapping("/enquiryFollowUp")
public class EnquiryFollowUpController {

	@Autowired
	private EnquiryFollowUpService enquiryFollowUpService;

	@GetMapping("/all")
	public List<EnquiryFollowUp> getAllEnquiryFollowUp() {
		return enquiryFollowUpService.getAllEnquiryFollowUps();
	}

	@GetMapping("/one/{id}")
	public EnquiryFollowUp getOneEnquiryFollowUp(@PathVariable Integer id) {
		return enquiryFollowUpService.getOneEnquiryFollowUp(id);
	}

	@PostMapping("/save")
	public String saveEnquiryFollowUp(@RequestBody EnquiryFollowUp enquiryFollowUp) {
		return enquiryFollowUpService.saveEnquiryFollowUp(enquiryFollowUp);
	}

	@PutMapping("/update")
	public String updateEnquiryFollowUp(@RequestBody EnquiryFollowUp enquiryFollowUp) {
		return enquiryFollowUpService.updateEnquiryFollowUp(enquiryFollowUp);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEnquiryFollowUp(@PathVariable Integer id) {
		return enquiryFollowUpService.deleteOneEnquiryFollowUp(id);
	}
}
