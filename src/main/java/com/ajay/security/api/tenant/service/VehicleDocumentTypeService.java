package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public VehicleDocumentType saveVehicleDocumentType(VehicleDocumentType vehicleDocumentType) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (vehicleDocumentType.getCreatedAt() == null)
			vehicleDocumentType.setCreatedAt(currentTimestamp);
		vehicleDocumentType.setUpdatedAt(currentTimestamp);
		return vehicleDocumentTypeRepository.save(vehicleDocumentType);
	}

	public String deleteOneVehicleDocumentType(VehicleDocumentType vehicleDocumentType) {
		String result = null;
		if (vehicleDocumentTypeRepository.existsById(vehicleDocumentType.getId())) {
			vehicleDocumentTypeRepository.delete(vehicleDocumentType);
			result = " VehicleDocumentType deleted!";
		} else {
			result = "VehicleDocumentType Not Found! or Already deleted!";
		}
		return result;
	}
}
