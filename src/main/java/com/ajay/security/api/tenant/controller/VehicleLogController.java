package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.VehicleLog;
import com.ajay.security.api.tenant.service.VehicleLogService;

@RestController
@RequestMapping("/vehicleLog")
public class VehicleLogController {

	@Autowired
	private VehicleLogService vehicleLogService;

	@GetMapping("/all")
	public List<VehicleLog> getAllVehicleLog() {
		return vehicleLogService.getAllVehicleLogs();
	}

	@GetMapping("/one/{id}")
	public VehicleLog getOneVehicleLog(@PathVariable Integer id) {
		return vehicleLogService.getOneVehicleLog(id);
	}

	@PostMapping("/save")
	public String saveVehicleLog(@RequestBody VehicleLog vehicleLog) {
		return vehicleLogService.saveVehicleLog(vehicleLog);
	}

	@PutMapping("/update")
	public String updateVehicleLog(@RequestBody VehicleLog vehicleLog) {
		return vehicleLogService.updateVehicleLog(vehicleLog);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehicleLog(@PathVariable Integer id) {
		return vehicleLogService.deleteOneVehicleLog(id);
	}
}
