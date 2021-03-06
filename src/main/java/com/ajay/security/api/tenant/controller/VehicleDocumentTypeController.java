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

import com.ajay.security.api.tenant.entity.VehicleDocumentType;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VehicleDocumentTypeService;

@RestController
@RequestMapping("/vehicleDocumentType")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleDocumentTypeController {

	@Autowired
	private VehicleDocumentTypeService vehicleDocumentTypeService;

	@GetMapping("/listAllVehicleDocumentType")
	public ApiResponse getAllVehicleDocumentType() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of VehicleDocumentType",
					vehicleDocumentTypeService.getAllVehicleDocumentTypes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVehicleDocumentType(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleDocumentType",
					vehicleDocumentTypeService.getOneVehicleDocumentType(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVehicleDocumentType")
	public ApiResponse saveVehicleDocumentType(@RequestBody VehicleDocumentType vehicleDocumentType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleDocumentType saved!",
					vehicleDocumentTypeService.saveVehicleDocumentType(vehicleDocumentType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVehicleDocumentType")
	public ApiResponse updateVehicleDocumentType(@RequestBody VehicleDocumentType vehicleDocumentType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleDocumentType updated!",
					vehicleDocumentTypeService.saveVehicleDocumentType(vehicleDocumentType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVehicleDocumentType")
	public ApiResponse deleteOneVehicleDocumentType(@RequestBody VehicleDocumentType vehicleDocumentType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					vehicleDocumentTypeService.deleteOneVehicleDocumentType(vehicleDocumentType), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}
}