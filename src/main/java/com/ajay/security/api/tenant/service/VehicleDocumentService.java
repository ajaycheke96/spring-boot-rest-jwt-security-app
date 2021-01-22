package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VehicleDocument;
import com.ajay.security.api.tenant.repository.VehicleDocumentRepository;

@Service
@Transactional
public class VehicleDocumentService {

	@Autowired
	private VehicleDocumentRepository vehicleDocumentRepository;

	public List<VehicleDocument> getAllVehicleDocuments() {
		return vehicleDocumentRepository.findAll();
	}

	public VehicleDocument getOneVehicleDocument(Integer id) {
		return vehicleDocumentRepository.findById(id).get();
	}

	public String saveVehicleDocument(VehicleDocument vehicleDocument) {
		return vehicleDocumentRepository.save(vehicleDocument) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVehicleDocument(VehicleDocument vehicleDocument) {
		return vehicleDocumentRepository.save(vehicleDocument) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVehicleDocument(Integer id) {
		vehicleDocumentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
