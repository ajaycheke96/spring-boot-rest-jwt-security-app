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

import com.ajay.security.api.tenant.entity.VehicleServiceCenter;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VehicleServiceCenterService;

@RestController
@RequestMapping("/vehicleServiceCenter")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleServiceCenterController {

	@Autowired
	private VehicleServiceCenterService vehicleServiceCenterService;

	@GetMapping("/listAllVehicleServiceCenter")
	public ApiResponse getAllVehicleServiceCenter() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of VehicleServiceCenter",
					vehicleServiceCenterService.getAllVehicleServiceCenters());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceCenter Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVehicleServiceCenter(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleServiceCenter",
					vehicleServiceCenterService.getOneVehicleServiceCenter(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceCenter Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVehicleServiceCenter")
	public ApiResponse saveVehicleServiceCenter(@RequestBody VehicleServiceCenter vehicleServiceCenter) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleServiceCenter saved!",
					vehicleServiceCenterService.saveVehicleServiceCenter(vehicleServiceCenter));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceCenter Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVehicleServiceCenter")
	public ApiResponse updateVehicleServiceCenter(@RequestBody VehicleServiceCenter vehicleServiceCenter) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleServiceCenter updated!",
					vehicleServiceCenterService.saveVehicleServiceCenter(vehicleServiceCenter));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceCenter Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVehicleServiceCenter")
	public ApiResponse deleteOneVehicleServiceCenter(@RequestBody VehicleServiceCenter vehicleServiceCenter) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					vehicleServiceCenterService.deleteOneVehicleServiceCenter(vehicleServiceCenter), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceCenter Service exception : " + e.getLocalizedMessage());
		}
	}
}
