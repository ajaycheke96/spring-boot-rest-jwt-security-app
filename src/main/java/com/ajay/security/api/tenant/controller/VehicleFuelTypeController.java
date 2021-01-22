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

import com.ajay.security.api.tenant.entity.VehicleFuelType;
import com.ajay.security.api.tenant.service.VehicleFuelTypeService;

@RestController
@RequestMapping("/vehicleFuelType")
public class VehicleFuelTypeController {

	@Autowired
	private VehicleFuelTypeService vehicleFuelTypeService;

	@GetMapping("/all")
	public List<VehicleFuelType> getAllVehicleFuelType() {
		return vehicleFuelTypeService.getAllVehicleFuelTypes();
	}

	@GetMapping("/one/{id}")
	public VehicleFuelType getOneVehicleFuelType(@PathVariable Integer id) {
		return vehicleFuelTypeService.getOneVehicleFuelType(id);
	}

	@PostMapping("/save")
	public String saveVehicleFuelType(@RequestBody VehicleFuelType vehicleFuelType) {
		return vehicleFuelTypeService.saveVehicleFuelType(vehicleFuelType);
	}

	@PutMapping("/update")
	public String updateVehicleFuelType(@RequestBody VehicleFuelType vehicleFuelType) {
		return vehicleFuelTypeService.updateVehicleFuelType(vehicleFuelType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehicleFuelType(@PathVariable Integer id) {
		return vehicleFuelTypeService.deleteOneVehicleFuelType(id);
	}
}
