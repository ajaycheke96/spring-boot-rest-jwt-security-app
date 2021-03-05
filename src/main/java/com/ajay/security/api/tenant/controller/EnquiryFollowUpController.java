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

import com.ajay.security.api.tenant.entity.EnquiryFollowUp;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EnquiryFollowUpService;

@RestController
@RequestMapping("/enquiryFollowUp")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EnquiryFollowUpController {

	@Autowired
	private EnquiryFollowUpService enquiryFollowUpService;

	@RequestMapping("/listAllEnquiryFollowUp")
	public ApiResponse getAllEnquiryFollowUp() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "List of EnquiryFollowUp",
					enquiryFollowUpService.getAllEnquiryFollowUps());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryFollowUp Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/{id}")
	public ApiResponse getOneEnquiryFollowUp(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EnquiryFollowUp",
					enquiryFollowUpService.getOneEnquiryFollowUp(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryFollowUp Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveEnquiryFollowUp", method = RequestMethod.POST)
	public ApiResponse saveEnquiryFollowUp(@RequestBody EnquiryFollowUp enquiryFollowUp) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EnquiryFollowUp saved!",
					enquiryFollowUpService.saveEnquiryFollowUp(enquiryFollowUp));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryFollowUp Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateEnquiryFollowUp", method = RequestMethod.POST)
	public ApiResponse updateEnquiryFollowUp(@RequestBody EnquiryFollowUp enquiryFollowUp) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EnquiryFollowUp updated!",
					enquiryFollowUpService.saveEnquiryFollowUp(enquiryFollowUp));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryFollowUp Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteEnquiryFollowUp", method = RequestMethod.POST)
	public ApiResponse deleteOneEnquiryFollowUp(@RequestBody EnquiryFollowUp enquiryFollowUp) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					enquiryFollowUpService.deleteOneEnquiryFollowUp(enquiryFollowUp), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryFollowUp Service exception : " + e.getLocalizedMessage());
		}
	}
}
