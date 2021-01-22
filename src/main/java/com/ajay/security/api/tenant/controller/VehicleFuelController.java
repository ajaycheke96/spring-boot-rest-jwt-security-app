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

import com.ajay.security.api.tenant.entity.VehicleFuel;
import com.ajay.security.api.tenant.service.VehicleFuelService;

@RestController
@RequestMapping("/vehicleFuel")
public class VehicleFuelController {

	@Autowired
	private VehicleFuelService vehicleFuelService;

	@GetMapping("/all")
	public List<VehicleFuel> getAllVehicleFuel() {
		return vehicleFuelService.getAllVehicleFuels();
	}

	@GetMapping("/one/{id}")
	public VehicleFuel getOneVehicleFuel(@PathVariable Integer id) {
		return vehicleFuelService.getOneVehicleFuel(id);
	}

	@PostMapping("/save")
	public String saveVehicleFuel(@RequestBody VehicleFuel vehicleFuel) {
		return vehicleFuelService.saveVehicleFuel(vehicleFuel);
	}

	@PutMapping("/update")
	public String updateVehicleFuel(@RequestBody VehicleFuel vehicleFuel) {
		return vehicleFuelService.updateVehicleFuel(vehicleFuel);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehicleFuel(@PathVariable Integer id) {
		return vehicleFuelService.deleteOneVehicleFuel(id);
	}
}
