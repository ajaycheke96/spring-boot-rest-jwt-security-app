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

import com.ajay.security.api.tenant.entity.VehiclePerformanceCriteria;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VehiclePerformanceCriteriaService;

@RestController
@RequestMapping("/vehiclePerformanceCriteria")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehiclePerformanceCriteriaController {

	@Autowired
	private VehiclePerformanceCriteriaService vehiclePerformanceCriteriaService;

	@GetMapping("/listAllVehiclePerformanceCriteria")
	public ApiResponse getAllVehiclePerformanceCriteria() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of VehiclePerformanceCriteria",
					vehiclePerformanceCriteriaService.getAllVehiclePerformanceCriterias());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehiclePerformanceCriteria Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVehiclePerformanceCriteria(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehiclePerformanceCriteria",
					vehiclePerformanceCriteriaService.getOneVehiclePerformanceCriteria(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehiclePerformanceCriteria Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVehiclePerformanceCriteria")
	public ApiResponse saveVehiclePerformanceCriteria(
			@RequestBody VehiclePerformanceCriteria vehiclePerformanceCriteria) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehiclePerformanceCriteria saved!",
					vehiclePerformanceCriteriaService.saveVehiclePerformanceCriteria(vehiclePerformanceCriteria));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehiclePerformanceCriteria Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVehiclePerformanceCriteria")
	public ApiResponse updateVehiclePerformanceCriteria(
			@RequestBody VehiclePerformanceCriteria vehiclePerformanceCriteria) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehiclePerformanceCriteria updated!",
					vehiclePerformanceCriteriaService.saveVehiclePerformanceCriteria(vehiclePerformanceCriteria));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehiclePerformanceCriteria Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVehiclePerformanceCriteria")
	public ApiResponse deleteOneVehiclePerformanceCriteria(
			@RequestBody VehiclePerformanceCriteria vehiclePerformanceCriteria) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					vehiclePerformanceCriteriaService.deleteOneVehiclePerformanceCriteria(vehiclePerformanceCriteria),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehiclePerformanceCriteria Service exception : " + e.getLocalizedMessage());
		}
	}
}
