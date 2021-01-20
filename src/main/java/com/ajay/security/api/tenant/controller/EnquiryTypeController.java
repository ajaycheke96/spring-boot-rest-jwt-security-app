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

import com.ajay.security.api.tenant.entity.EnquiryType;
import com.ajay.security.api.tenant.service.EnquiryTypeService;

@RestController
@RequestMapping("/enquiryType")
public class EnquiryTypeController {

	@Autowired
	private EnquiryTypeService enquiryTypeService;

	@GetMapping("/all")
	public List<EnquiryType> getAllEnquiryType() {
		return enquiryTypeService.getAllEnquiryTypes();
	}

	@GetMapping("/one/{id}")
	public EnquiryType getOneEnquiryType(@PathVariable Integer id) {
		return enquiryTypeService.getOneEnquiryType(id);
	}

	@PostMapping("/save")
	public String saveEnquiryType(@RequestBody EnquiryType enquiryType) {
		return enquiryTypeService.saveEnquiryType(enquiryType);
	}

	@PutMapping("/update")
	public String updateEnquiryType(@RequestBody EnquiryType enquiryType) {
		return enquiryTypeService.updateEnquiryType(enquiryType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEnquiryType(@PathVariable Integer id) {
		return enquiryTypeService.deleteOneEnquiryType(id);
	}
}
