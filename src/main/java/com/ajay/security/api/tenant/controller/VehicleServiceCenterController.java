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

import com.ajay.security.api.tenant.entity.VehicleServiceCenter;
import com.ajay.security.api.tenant.service.VehicleServiceCenterService;

@RestController
@RequestMapping("/vehicleServiceCenter")
public class VehicleServiceCenterController {

	@Autowired
	private VehicleServiceCenterService vehicleServiceCenterService;

	@GetMapping("/all")
	public List<VehicleServiceCenter> getAllVehicleServiceCenter() {
		return vehicleServiceCenterService.getAllVehicleServiceCenters();
	}

	@GetMapping("/one/{id}")
	public VehicleServiceCenter getOneVehicleServiceCenter(@PathVariable Integer id) {
		return vehicleServiceCenterService.getOneVehicleServiceCenter(id);
	}

	@PostMapping("/save")
	public String saveVehicleServiceCenter(@RequestBody VehicleServiceCenter vehicleServiceCenter) {
		return vehicleServiceCenterService.saveVehicleServiceCenter(vehicleServiceCenter);
	}

	@PutMapping("/update")
	public String updateVehicleServiceCenter(@RequestBody VehicleServiceCenter vehicleServiceCenter) {
		return vehicleServiceCenterService.updateVehicleServiceCenter(vehicleServiceCenter);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehicleServiceCenter(@PathVariable Integer id) {
		return vehicleServiceCenterService.deleteOneVehicleServiceCenter(id);
	}
}
