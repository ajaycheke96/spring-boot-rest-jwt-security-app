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

import com.ajay.security.api.tenant.entity.VehicleIncharge;
import com.ajay.security.api.tenant.service.VehicleInchargeService;

@RestController
@RequestMapping("/vehicleIncharge")
public class VehicleInchargeController {

	@Autowired
	private VehicleInchargeService vehicleInchargeService;

	@GetMapping("/all")
	public List<VehicleIncharge> getAllVehicleIncharge() {
		return vehicleInchargeService.getAllVehicleIncharges();
	}

	@GetMapping("/one/{id}")
	public VehicleIncharge getOneVehicleIncharge(@PathVariable Integer id) {
		return vehicleInchargeService.getOneVehicleIncharge(id);
	}

	@PostMapping("/save")
	public String saveVehicleIncharge(@RequestBody VehicleIncharge vehicleIncharge) {
		return vehicleInchargeService.saveVehicleIncharge(vehicleIncharge);
	}

	@PutMapping("/update")
	public String updateVehicleIncharge(@RequestBody VehicleIncharge vehicleIncharge) {
		return vehicleInchargeService.updateVehicleIncharge(vehicleIncharge);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehicleIncharge(@PathVariable Integer id) {
		return vehicleInchargeService.deleteOneVehicleIncharge(id);
	}
}
