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

import com.ajay.security.api.tenant.entity.Complaint;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ComplaintService;

@RestController
@RequestMapping("/complaint")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@GetMapping("/listAllComplaint")
	public ApiResponse getAllComplaint() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Complaint",
					complaintService.getAllComplaints());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Complaint Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneComplaint(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Complaint", complaintService.getOneComplaint(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Complaint Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveComplaint")
	public ApiResponse saveComplaint(@RequestBody Complaint complaint) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Complaint saved!",
					complaintService.saveComplaint(complaint));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Complaint Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateComplaint")
	public ApiResponse updateComplaint(@RequestBody Complaint complaint) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Complaint updated!",
					complaintService.saveComplaint(complaint));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Complaint Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteComplaint")
	public ApiResponse deleteOneComplaint(@RequestBody Complaint complaint) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, complaintService.deleteOneComplaint(complaint),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Complaint Service exception : " + e.getLocalizedMessage());
		}
	}
}
