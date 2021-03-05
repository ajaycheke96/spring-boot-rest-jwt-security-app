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

import com.ajay.security.api.tenant.entity.Caste;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.CasteService;

@RestController
@RequestMapping("/caste")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CasteController {

	@Autowired
	private CasteService casteService;

	@GetMapping("/listAllCaste")
	public ApiResponse getAllCaste() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Caste", casteService.getAllCastes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Caste Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneCaste(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Caste", casteService.getOneCaste(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Caste Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveCaste")
	public ApiResponse saveCaste(@RequestBody Caste caste) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Caste saved!", casteService.saveCaste(caste));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Caste Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateCaste")
	public ApiResponse updateCaste(@RequestBody Caste caste) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Caste updated!", casteService.saveCaste(caste));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Caste Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteCaste")
	public ApiResponse deleteOneCaste(@RequestBody Caste caste) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, casteService.deleteOneCaste(caste), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Caste Service exception : " + e.getLocalizedMessage());
		}
	}
}
