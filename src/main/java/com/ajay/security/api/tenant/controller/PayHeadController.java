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

import com.ajay.security.api.tenant.entity.PayHead;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.PayHeadService;

@RestController
@RequestMapping("/payHead")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PayHeadController {

	@Autowired
	private PayHeadService payHeadService;

	@GetMapping("/listAllPayHead")
	public ApiResponse getAllPayHead() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of PayHead", payHeadService.getAllPayHeads());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayHead Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOnePayHead(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PayHead", payHeadService.getOnePayHead(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayHead Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/savePayHead")
	public ApiResponse savePayHead(@RequestBody PayHead payHead) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PayHead saved!",
					payHeadService.savePayHead(payHead));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayHead Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updatePayHead")
	public ApiResponse updatePayHead(@RequestBody PayHead payHead) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PayHead updated!",
					payHeadService.savePayHead(payHead));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayHead Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deletePayHead")
	public ApiResponse deleteOnePayHead(@RequestBody PayHead payHead) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, payHeadService.deleteOnePayHead(payHead), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayHead Service exception : " + e.getLocalizedMessage());
		}
	}
}
