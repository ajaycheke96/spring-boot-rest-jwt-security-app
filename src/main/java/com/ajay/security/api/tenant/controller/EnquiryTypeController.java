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

import com.ajay.security.api.tenant.entity.EnquiryType;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EnquiryTypeService;

@RestController
@RequestMapping("/enquiryType")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EnquiryTypeController {

	@Autowired
	private EnquiryTypeService enquiryTypeService;

	@RequestMapping(value = "/listAllEnquiryType")
	public ApiResponse getAllEnquiryType() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "List of EnquiryType",
					enquiryTypeService.getAllEnquiryTypes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryType Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/{id}")
	public ApiResponse getOneEnquiryType(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EnquiryType",
					enquiryTypeService.getOneEnquiryType(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryType Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveEnquiryType", method = RequestMethod.POST)
	public ApiResponse saveEnquiryType(@RequestBody EnquiryType enquiryType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EnquiryType saved!",
					enquiryTypeService.saveEnquiryType(enquiryType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryType Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateEnquiryType", method = RequestMethod.POST)
	public ApiResponse updateEnquiryType(@RequestBody EnquiryType enquiryType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EnquiryType updated!",
					enquiryTypeService.saveEnquiryType(enquiryType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryType Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteEnquiryType", method = RequestMethod.POST)
	public ApiResponse deleteOneEnquiryType(@RequestBody EnquiryType enquiryType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, enquiryTypeService.deleteOneEnquiryType(enquiryType),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquiryType Service exception : " + e.getLocalizedMessage());
		}
	}
}
