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

import com.ajay.security.api.tenant.entity.Vehicle;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/listAllVehicle")
	public ApiResponse getAllVehicle() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Vehicle", vehicleService.getAllVehicles());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vehicle Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVehicle(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Vehicle", vehicleService.getOneVehicle(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vehicle Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVehicle")
	public ApiResponse saveVehicle(@RequestBody Vehicle vehicle) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Vehicle saved!",
					vehicleService.saveVehicle(vehicle));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vehicle Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVehicle")
	public ApiResponse updateVehicle(@RequestBody Vehicle vehicle) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Vehicle updated!",
					vehicleService.saveVehicle(vehicle));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vehicle Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVehicle")
	public ApiResponse deleteOneVehicle(@RequestBody Vehicle vehicle) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, vehicleService.deleteOneVehicle(vehicle), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vehicle Service exception : " + e.getLocalizedMessage());
		}
	}
}
