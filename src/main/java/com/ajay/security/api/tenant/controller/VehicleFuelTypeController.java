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

import com.ajay.security.api.tenant.entity.VehicleFuelType;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VehicleFuelTypeService;

@RestController
@RequestMapping("/vehicleFuelType")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleFuelTypeController {

	@Autowired
	private VehicleFuelTypeService vehicleFuelTypeService;

	@GetMapping("/listAllVehicleFuelType")
	public ApiResponse getAllVehicleFuelType() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of VehicleFuelType",
					vehicleFuelTypeService.getAllVehicleFuelTypes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleFuelType Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVehicleFuelType(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleFuelType",
					vehicleFuelTypeService.getOneVehicleFuelType(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleFuelType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVehicleFuelType")
	public ApiResponse saveVehicleFuelType(@RequestBody VehicleFuelType vehicleFuelType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleFuelType saved!",
					vehicleFuelTypeService.saveVehicleFuelType(vehicleFuelType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleFuelType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVehicleFuelType")
	public ApiResponse updateVehicleFuelType(@RequestBody VehicleFuelType vehicleFuelType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleFuelType updated!",
					vehicleFuelTypeService.saveVehicleFuelType(vehicleFuelType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleFuelType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVehicleFuelType")
	public ApiResponse deleteOneVehicleFuelType(@RequestBody VehicleFuelType vehicleFuelType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					vehicleFuelTypeService.deleteOneVehicleFuelType(vehicleFuelType), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleFuelType Service exception : " + e.getLocalizedMessage());
		}
	}
}
