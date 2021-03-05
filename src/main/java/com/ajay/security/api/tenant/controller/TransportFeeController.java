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

import com.ajay.security.api.tenant.entity.TransportFee;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TransportFeeService;

@RestController
@RequestMapping("/transportFee")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransportFeeController {

	@Autowired
	private TransportFeeService transportFeeService;

	@GetMapping("/listAllTransportFee")
	public ApiResponse getAllTransportFee() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of TransportFee",
					transportFeeService.getAllTransportFees());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportFee Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTransportFee(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransportFee",
					transportFeeService.getOneTransportFee(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportFee Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTransportFee")
	public ApiResponse saveTransportFee(@RequestBody TransportFee transportFee) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransportFee saved!",
					transportFeeService.saveTransportFee(transportFee));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportFee Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTransportFee")
	public ApiResponse updateTransportFee(@RequestBody TransportFee transportFee) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransportFee updated!",
					transportFeeService.saveTransportFee(transportFee));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportFee Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTransportFee")
	public ApiResponse deleteOneTransportFee(@RequestBody TransportFee transportFee) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					transportFeeService.deleteOneTransportFee(transportFee), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportFee Service exception : " + e.getLocalizedMessage());
		}
	}
}
