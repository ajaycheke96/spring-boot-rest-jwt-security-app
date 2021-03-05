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

import com.ajay.security.api.tenant.entity.VehicleServiceRecord;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VehicleServiceRecordService;

@RestController
@RequestMapping("/vehicleServiceRecord")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleServiceRecordController {

	@Autowired
	private VehicleServiceRecordService vehicleServiceRecordService;

	@GetMapping("/listAllVehicleServiceRecord")
	public ApiResponse getAllVehicleServiceRecord() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of VehicleServiceRecord",
					vehicleServiceRecordService.getAllVehicleServiceRecords());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVehicleServiceRecord(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleServiceRecord",
					vehicleServiceRecordService.getOneVehicleServiceRecord(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVehicleServiceRecord")
	public ApiResponse saveVehicleServiceRecord(@RequestBody VehicleServiceRecord vehicleServiceRecord) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleServiceRecord saved!",
					vehicleServiceRecordService.saveVehicleServiceRecord(vehicleServiceRecord));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVehicleServiceRecord")
	public ApiResponse updateVehicleServiceRecord(@RequestBody VehicleServiceRecord vehicleServiceRecord) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "VehicleServiceRecord updated!",
					vehicleServiceRecordService.saveVehicleServiceRecord(vehicleServiceRecord));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVehicleServiceRecord")
	public ApiResponse deleteOneVehicleServiceRecord(@RequestBody VehicleServiceRecord vehicleServiceRecord) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					vehicleServiceRecordService.deleteOneVehicleServiceRecord(vehicleServiceRecord), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"VehicleServiceRecord Service exception : " + e.getLocalizedMessage());
		}
	}
}
