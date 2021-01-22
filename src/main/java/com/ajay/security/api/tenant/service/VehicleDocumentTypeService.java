package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VehicleDocumentType;
import com.ajay.security.api.tenant.repository.VehicleDocumentTypeRepository;

@Service
@Transactional
public class VehicleDocumentTypeService {

	@Autowired
	private VehicleDocumentTypeRepository vehicleDocumentTypeRepository;

	public List<VehicleDocumentType> getAllVehicleDocumentTypes() {
		return vehicleDocumentTypeRepository.findAll();
	}

	public VehicleDocumentType getOneVehicleDocumentType(Integer id) {
		return vehicleDocumentTypeRepository.findById(id).get();
	}

	public String saveVehicleDocumentType(VehicleDocumentType vehicleDocumentType) {
		return vehicleDocumentTypeRepository.save(vehicleDocumentType) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVehicleDocumentType(VehicleDocumentType vehicleDocumentType) {
		return vehicleDocumentTypeRepository.save(vehicleDocumentType) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVehicleDocumentType(Integer id) {
		vehicleDocumentTypeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
