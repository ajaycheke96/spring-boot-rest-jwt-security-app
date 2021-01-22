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

import com.ajay.security.api.tenant.entity.VehicleDocument;
import com.ajay.security.api.tenant.service.VehicleDocumentService;

@RestController
@RequestMapping("/vehicleDocument")
public class VehicleDocumentController {

	@Autowired
	private VehicleDocumentService vehicleDocumentService;

	@GetMapping("/all")
	public List<VehicleDocument> getAllVehicleDocument() {
		return vehicleDocumentService.getAllVehicleDocuments();
	}

	@GetMapping("/one/{id}")
	public VehicleDocument getOneVehicleDocument(@PathVariable Integer id) {
		return vehicleDocumentService.getOneVehicleDocument(id);
	}

	@PostMapping("/save")
	public String saveVehicleDocument(@RequestBody VehicleDocument vehicleDocument) {
		return vehicleDocumentService.saveVehicleDocument(vehicleDocument);
	}

	@PutMapping("/update")
	public String updateVehicleDocument(@RequestBody VehicleDocument vehicleDocument) {
		return vehicleDocumentService.updateVehicleDocument(vehicleDocument);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehicleDocument(@PathVariable Integer id) {
		return vehicleDocumentService.deleteOneVehicleDocument(id);
	}
}
