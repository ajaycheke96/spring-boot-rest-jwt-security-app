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

import com.ajay.security.api.tenant.entity.TransportRoute;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TransportRouteService;

@RestController
@RequestMapping("/transportRoute")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransportRouteController {

	@Autowired
	private TransportRouteService transportRouteService;

	@GetMapping("/listAllTransportRoute")
	public ApiResponse getAllTransportRoute() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of TransportRoute",
					transportRouteService.getAllTransportRoutes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportRoute Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTransportRoute(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransportRoute",
					transportRouteService.getOneTransportRoute(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportRoute Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTransportRoute")
	public ApiResponse saveTransportRoute(@RequestBody TransportRoute transportRoute) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransportRoute saved!",
					transportRouteService.saveTransportRoute(transportRoute));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportRoute Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTransportRoute")
	public ApiResponse updateTransportRoute(@RequestBody TransportRoute transportRoute) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransportRoute updated!",
					transportRouteService.saveTransportRoute(transportRoute));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportRoute Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTransportRoute")
	public ApiResponse deleteOneTransportRoute(@RequestBody TransportRoute transportRoute) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					transportRouteService.deleteOneTransportRoute(transportRoute), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransportRoute Service exception : " + e.getLocalizedMessage());
		}
	}

}
