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

import com.ajay.security.api.tenant.entity.EnquirySource;
import com.ajay.security.api.tenant.service.EnquirySourceService;

@RestController
@RequestMapping("/enquirySource")
public class EnquirySourceController {

	@Autowired
	private EnquirySourceService enquirySourceService;

	@GetMapping("/all")
	public List<EnquirySource> getAllEnquirySource() {
		return enquirySourceService.getAllEnquirySources();
	}

	@GetMapping("/one/{id}")
	public EnquirySource getOneEnquirySource(@PathVariable Integer id) {
		return enquirySourceService.getOneEnquirySource(id);
	}

	@PostMapping("/save")
	public String saveEnquirySource(@RequestBody EnquirySource enquirySource) {
		return enquirySourceService.saveEnquirySource(enquirySource);
	}

	@PutMapping("/update")
	public String updateEnquirySource(@RequestBody EnquirySource enquirySource) {
		return enquirySourceService.updateEnquirySource(enquirySource);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEnquirySource(@PathVariable Integer id) {
		return enquirySourceService.deleteOneEnquirySource(id);
	}
}
