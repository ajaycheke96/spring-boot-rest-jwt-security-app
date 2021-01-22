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

import com.ajay.security.api.tenant.entity.VehicleDocumentType;
import com.ajay.security.api.tenant.service.VehicleDocumentTypeService;

@RestController
@RequestMapping("/vehicleDocumentTypeDocumentType")
public class VehicleDocumentTypeController {

	@Autowired
	private VehicleDocumentTypeService vehicleDocumentTypeService;

	@GetMapping("/all")
	public List<VehicleDocumentType> getAllVehicleDocumentType() {
		return vehicleDocumentTypeService.getAllVehicleDocumentTypes();
	}

	@GetMapping("/one/{id}")
	public VehicleDocumentType getOneVehicleDocumentType(@PathVariable Integer id) {
		return vehicleDocumentTypeService.getOneVehicleDocumentType(id);
	}

	@PostMapping("/save")
	public String saveVehicleDocumentType(@RequestBody VehicleDocumentType vehicleDocumentType) {
		return vehicleDocumentTypeService.saveVehicleDocumentType(vehicleDocumentType);
	}

	@PutMapping("/update")
	public String updateVehicleDocumentType(@RequestBody VehicleDocumentType vehicleDocumentType) {
		return vehicleDocumentTypeService.updateVehicleDocumentType(vehicleDocumentType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehicleDocumentType(@PathVariable Integer id) {
		return vehicleDocumentTypeService.deleteOneVehicleDocumentType(id);
	}
}