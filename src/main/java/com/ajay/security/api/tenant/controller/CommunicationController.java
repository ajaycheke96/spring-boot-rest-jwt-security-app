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

import com.ajay.security.api.tenant.entity.Communication;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.CommunicationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/communication")
public class CommunicationController {

	@Autowired
	private CommunicationService communicationService;

	@GetMapping("/listAllCommunication")
	public ApiResponse getAllCommunication() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Communication",
					communicationService.getAllCommunications());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Communication" + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneCommunication(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Communication",
					communicationService.getOneCommunication(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Communication" + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveCommunication")
	public ApiResponse saveCommunication(@RequestBody Communication communication) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Communication saved!",
					communicationService.saveCommunication(communication));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Communication" + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateCommunication")
	public ApiResponse updateCommunication(@RequestBody Communication communication) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Communication updated!",
					communicationService.saveCommunication(communication));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Communication" + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteCommunication")
	public ApiResponse deleteOneCommunication(@RequestBody Communication communication) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Communication deleted!",
					communicationService.deleteOneCommunication(communication));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Communication" + e.getLocalizedMessage());
		}
	}
}
