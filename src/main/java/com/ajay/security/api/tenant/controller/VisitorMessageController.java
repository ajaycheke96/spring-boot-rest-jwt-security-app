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

import com.ajay.security.api.tenant.entity.VisitorMessage;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VisitorMessageService;

@RestController
@RequestMapping("/visitorMessage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VisitorMessageController {

	@Autowired
	private VisitorMessageService visitorMessageService;

	@GetMapping("/listAllVisitorMessage")
	public ApiResponse getAllVisitorMessage() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of VisitorMessage",
					visitorMessageService.getAllVisitorMessages());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorMessage Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVisitorMessage(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VisitorMessage",
					visitorMessageService.getOneVisitorMessage(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorMessage Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVisitorMessage")
	public ApiResponse saveVisitorMessage(@RequestBody VisitorMessage visitorMessage) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VisitorMessage saved!",
					visitorMessageService.saveVisitorMessage(visitorMessage));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorMessage Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVisitorMessage")
	public ApiResponse updateVisitorMessage(@RequestBody VisitorMessage visitorMessage) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VisitorMessage updated!",
					visitorMessageService.saveVisitorMessage(visitorMessage));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorMessage Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVisitorMessage")
	public ApiResponse deleteOneVisitorMessage(@RequestBody VisitorMessage visitorMessage) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					visitorMessageService.deleteOneVisitorMessage(visitorMessage), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VisitorMessage Service exception : " + e.getLocalizedMessage());
		}
	}
}
