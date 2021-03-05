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

import com.ajay.security.api.tenant.entity.VehicleIncharge;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VehicleInchargeService;

@RestController
@RequestMapping("/vehicleIncharge")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleInchargeController {

	@Autowired
	private VehicleInchargeService vehicleInchargeService;

	@GetMapping("/listAllVehicleIncharge")
	public ApiResponse getAllVehicleIncharge() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of VehicleIncharge",
					vehicleInchargeService.getAllVehicleIncharges());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleIncharge Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVehicleIncharge(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleIncharge",
					vehicleInchargeService.getOneVehicleIncharge(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleIncharge Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVehicleIncharge")
	public ApiResponse saveVehicleIncharge(@RequestBody VehicleIncharge vehicleIncharge) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleIncharge saved!",
					vehicleInchargeService.saveVehicleIncharge(vehicleIncharge));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleIncharge Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVehicleIncharge")
	public ApiResponse updateVehicleIncharge(@RequestBody VehicleIncharge vehicleIncharge) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleIncharge updated!",
					vehicleInchargeService.saveVehicleIncharge(vehicleIncharge));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleIncharge Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVehicleIncharge")
	public ApiResponse deleteOneVehicleIncharge(@RequestBody VehicleIncharge vehicleIncharge) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					vehicleInchargeService.deleteOneVehicleIncharge(vehicleIncharge), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleIncharge Service exception : " + e.getLocalizedMessage());
		}
	}
}
