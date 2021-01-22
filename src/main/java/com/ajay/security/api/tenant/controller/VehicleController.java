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

import com.ajay.security.api.tenant.entity.Vehicle;
import com.ajay.security.api.tenant.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/all")
	public List<Vehicle> getAllVehicle() {
		return vehicleService.getAllVehicles();
	}

	@GetMapping("/one/{id}")
	public Vehicle getOneVehicle(@PathVariable Integer id) {
		return vehicleService.getOneVehicle(id);
	}

	@PostMapping("/save")
	public String saveVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);
	}

	@PutMapping("/update")
	public String updateVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.updateVehicle(vehicle);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehicle(@PathVariable Integer id) {
		return vehicleService.deleteOneVehicle(id);
	}
}
