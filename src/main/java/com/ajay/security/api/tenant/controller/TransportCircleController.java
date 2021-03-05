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

import com.ajay.security.api.tenant.entity.TransportCircle;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TransportCircleService;

@RestController
@RequestMapping("/transportCircle")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransportCircleController {

	@Autowired
	private TransportCircleService transportCircleService;

	@GetMapping("/listAllTransportCircle")
	public ApiResponse getAllTransportCircle() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of TransportCircle",
					transportCircleService.getAllTransportCircles());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportCircle Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTransportCircle(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransportCircle",
					transportCircleService.getOneTransportCircle(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportCircle Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTransportCircle")
	public ApiResponse saveTransportCircle(@RequestBody TransportCircle transportCircle) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransportCircle saved!",
					transportCircleService.saveTransportCircle(transportCircle));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportCircle Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTransportCircle")
	public ApiResponse updateTransportCircle(@RequestBody TransportCircle transportCircle) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransportCircle updated!",
					transportCircleService.saveTransportCircle(transportCircle));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportCircle Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTransportCircle")
	public ApiResponse deleteOneTransportCircle(@RequestBody TransportCircle transportCircle) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					transportCircleService.deleteOneTransportCircle(transportCircle), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportCircle Service exception : " + e.getLocalizedMessage());
		}
	}
}
