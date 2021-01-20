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

import com.ajay.security.api.tenant.entity.EnquiryDetail;
import com.ajay.security.api.tenant.service.EnquiryDetailService;

@RestController
@RequestMapping("/enquiryDetail")
public class EnquiryDetailController {

	@Autowired
	private EnquiryDetailService enquiryDetailService;

	@GetMapping("/all")
	public List<EnquiryDetail> getAllEnquiryDetail() {
		return enquiryDetailService.getAllEnquiryDetails();
	}

	@GetMapping("/one/{id}")
	public EnquiryDetail getOneEnquiryDetail(@PathVariable Integer id) {
		return enquiryDetailService.getOneEnquiryDetail(id);
	}

	@PostMapping("/save")
	public String saveEnquiryDetail(@RequestBody EnquiryDetail enquiryDetail) {
		return enquiryDetailService.saveEnquiryDetail(enquiryDetail);
	}

	@PutMapping("/update")
	public String updateEnquiryDetail(@RequestBody EnquiryDetail enquiryDetail) {
		return enquiryDetailService.updateEnquiryDetail(enquiryDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEnquiryDetail(@PathVariable Integer id) {
		return enquiryDetailService.deleteOneEnquiryDetail(id);
	}
}
