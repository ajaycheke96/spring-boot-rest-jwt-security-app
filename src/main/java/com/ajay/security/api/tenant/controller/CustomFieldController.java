package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.CustomField;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.CustomFieldService;

@RestController
@RequestMapping("/customField")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomFieldController {

	@Autowired
	private CustomFieldService customFieldService;

	@GetMapping("/listAllCustomField")
	public ApiResponse getAllCustomField() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of CustomField",
					customFieldService.getAllCustomFields());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CustomField Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneCustomField(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "CustomField",
					customFieldService.getOneCustomField(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CustomField Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveCustomField")
	public ApiResponse saveCustomField(@RequestBody CustomField customField) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "CustomField saved!",
					customFieldService.saveCustomField(customField));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CustomField Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateCustomField")
	public ApiResponse updateCustomField(@RequestBody CustomField customField) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "CustomField updated!",
					customFieldService.saveCustomField(customField));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CustomField Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteCustomField")
	public ApiResponse deleteOneCustomField(@RequestBody CustomField customField) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, customFieldService.deleteOneCustomField(customField),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CustomField Service exception : " + e.getLocalizedMessage());
		}
	}
}
