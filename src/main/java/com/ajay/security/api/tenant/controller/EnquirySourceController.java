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

import com.ajay.security.api.tenant.entity.EnquirySource;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EnquirySourceService;

@RestController
@RequestMapping("/enquirySource")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EnquirySourceController {

	@Autowired
	private EnquirySourceService enquirySourceService;

	@RequestMapping(value = "/listAllEnquirySource")
	public ApiResponse getAllEnquirySource() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "List of EnquirySource",
					enquirySourceService.getAllEnquirySources());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquirySource Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/{id}")
	public ApiResponse getOneEnquirySource(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EnquirySource",
					enquirySourceService.getOneEnquirySource(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquirySource Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveEnquirySource", method = RequestMethod.POST)
	public ApiResponse saveEnquirySource(@RequestBody EnquirySource enquirySource) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EnquirySource saved!",
					enquirySourceService.saveEnquirySource(enquirySource));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquirySource Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateEnquirySource", method = RequestMethod.POST)
	public ApiResponse updateEnquirySource(@RequestBody EnquirySource enquirySource) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EnquirySource updated!",
					enquirySourceService.saveEnquirySource(enquirySource));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquirySource Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteEnquirySource", method = RequestMethod.POST)
	public ApiResponse deleteOneEnquirySource(@RequestBody EnquirySource enquirySource) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					enquirySourceService.deleteOneEnquirySource(enquirySource), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EnquirySource Service exception : " + e.getLocalizedMessage());
		}
	}
}
