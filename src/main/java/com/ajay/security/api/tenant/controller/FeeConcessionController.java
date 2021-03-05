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

import com.ajay.security.api.tenant.entity.FeeConcession;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.FeeConcessionService;

@RestController
@RequestMapping("/feeConcession")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeeConcessionController {

	@Autowired
	private FeeConcessionService feeConcessionService;

	@GetMapping("/listAllFeeConcession")
	public ApiResponse getAllFeeConcession() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of FeeConcession",
					feeConcessionService.getAllFeeConcessions());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeConcession Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneFeeConcession(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeConcession",
					feeConcessionService.getOneFeeConcession(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeConcession Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveFeeConcession")
	public ApiResponse saveFeeConcession(@RequestBody FeeConcession feeConcession) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeConcession saved!",
					feeConcessionService.saveFeeConcession(feeConcession));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeConcession Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateFeeConcession")
	public ApiResponse updateFeeConcession(@RequestBody FeeConcession feeConcession) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeConcession updated!",
					feeConcessionService.saveFeeConcession(feeConcession));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeConcession Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteFeeConcession")
	public ApiResponse deleteOneFeeConcession(@RequestBody FeeConcession feeConcession) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					feeConcessionService.deleteOneFeeConcession(feeConcession), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeConcession Service exception : " + e.getLocalizedMessage());
		}
	}
}
