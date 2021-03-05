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

import com.ajay.security.api.tenant.entity.ComplaintType;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ComplaintTypeService;

@RestController
@RequestMapping("/complaintType")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ComplaintTypeController {

	@Autowired
	private ComplaintTypeService complaintTypeService;

	@GetMapping("/listAllComplaintType")
	public ApiResponse getAllComplaintType() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ComplaintType",
					complaintTypeService.getAllComplaintTypes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ComplaintType Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneComplaintType(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ComplaintType",
					complaintTypeService.getOneComplaintType(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ComplaintType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveComplaintType")
	public ApiResponse saveComplaintType(@RequestBody ComplaintType complaintType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ComplaintType saved!",
					complaintTypeService.saveComplaintType(complaintType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ComplaintType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateComplaintType")
	public ApiResponse updateComplaintType(@RequestBody ComplaintType complaintType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ComplaintType updated!",
					complaintTypeService.saveComplaintType(complaintType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ComplaintType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteComplaintType")
	public ApiResponse deleteOneComplaintType(@RequestBody ComplaintType complaintType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					complaintTypeService.deleteOneComplaintType(complaintType), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ComplaintType Service exception : " + e.getLocalizedMessage());
		}
	}
}
