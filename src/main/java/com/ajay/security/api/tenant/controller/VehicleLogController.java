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

import com.ajay.security.api.tenant.entity.VehicleLog;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VehicleLogService;

@RestController
@RequestMapping("/vehicleLog")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleLogController {

	@Autowired
	private VehicleLogService vehicleLogService;

	@GetMapping("/listAllVehicleLog")
	public ApiResponse getAllVehicleLog() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of VehicleLog",
					vehicleLogService.getAllVehicleLogs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVehicleLog(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleLog",
					vehicleLogService.getOneVehicleLog(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVehicleLog")
	public ApiResponse saveVehicleLog(@RequestBody VehicleLog vehicleLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleLog saved!",
					vehicleLogService.saveVehicleLog(vehicleLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVehicleLog")
	public ApiResponse updateVehicleLog(@RequestBody VehicleLog vehicleLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleLog updated!",
					vehicleLogService.saveVehicleLog(vehicleLog));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleLog Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVehicleLog")
	public ApiResponse deleteOneVehicleLog(@RequestBody VehicleLog vehicleLog) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, vehicleLogService.deleteOneVehicleLog(vehicleLog),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleLog Service exception : " + e.getLocalizedMessage());
		}
	}
}
