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

import com.ajay.security.api.tenant.entity.VehiclePerformanceCriteria;
import com.ajay.security.api.tenant.service.VehiclePerformanceCriteriaService;

@RestController
@RequestMapping("/vehiclePerformanceCriteria")
public class VehiclePerformanceCriteriaController {

	@Autowired
	private VehiclePerformanceCriteriaService vehiclePerformanceCriteriaService;

	@GetMapping("/all")
	public List<VehiclePerformanceCriteria> getAllVehiclePerformanceCriteria() {
		return vehiclePerformanceCriteriaService.getAllVehiclePerformanceCriterias();
	}

	@GetMapping("/one/{id}")
	public VehiclePerformanceCriteria getOneVehiclePerformanceCriteria(@PathVariable Integer id) {
		return vehiclePerformanceCriteriaService.getOneVehiclePerformanceCriteria(id);
	}

	@PostMapping("/save")
	public String saveVehiclePerformanceCriteria(@RequestBody VehiclePerformanceCriteria vehiclePerformanceCriteria) {
		return vehiclePerformanceCriteriaService.saveVehiclePerformanceCriteria(vehiclePerformanceCriteria);
	}

	@PutMapping("/update")
	public String updateVehiclePerformanceCriteria(@RequestBody VehiclePerformanceCriteria vehiclePerformanceCriteria) {
		return vehiclePerformanceCriteriaService.updateVehiclePerformanceCriteria(vehiclePerformanceCriteria);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehiclePerformanceCriteria(@PathVariable Integer id) {
		return vehiclePerformanceCriteriaService.deleteOneVehiclePerformanceCriteria(id);
	}
}
