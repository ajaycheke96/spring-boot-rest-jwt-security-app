package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Enquiry;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@RequestMapping(value = "/listAllEnquiry")
	public ApiResponse getAllEnquiry() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "List of Enquiry", enquiryService.getAllEnquirys());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Enquiry Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/{id}")
	public ApiResponse getOneEnquiry(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Enquiry", enquiryService.getOneEnquiry(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Enquiry Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveEnquiry", method = RequestMethod.POST)
	public ApiResponse saveEnquiry(@RequestBody Enquiry enquiry) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Enquiry saved!",
					enquiryService.saveEnquiry(enquiry));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Enquiry Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateEnquiry", method = RequestMethod.POST)
	public ApiResponse updateEnquiry(@RequestBody Enquiry enquiry) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Enquiry updated!",
					enquiryService.saveEnquiry(enquiry));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Enquiry Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteEnquiry", method = RequestMethod.POST)
	public ApiResponse deleteOneEnquiry(@RequestBody Enquiry enquiry) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, enquiryService.deleteOneEnquiry(enquiry), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Enquiry Service exception : " + e.getLocalizedMessage());
		}
	}
}
