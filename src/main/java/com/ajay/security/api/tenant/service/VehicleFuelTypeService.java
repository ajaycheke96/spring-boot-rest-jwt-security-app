package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VehicleFuelType;
import com.ajay.security.api.tenant.repository.VehicleFuelTypeRepository;

@Service
@Transactional
public class VehicleFuelTypeService {

	@Autowired
	private VehicleFuelTypeRepository vehicleFuelTypeRepository;

	public List<VehicleFuelType> getAllVehicleFuelTypes() {
		return vehicleFuelTypeRepository.findAll();
	}

	public VehicleFuelType getOneVehicleFuelType(Integer id) {
		return vehicleFuelTypeRepository.findById(id).get();
	}

	public VehicleFuelType saveVehicleFuelType(VehicleFuelType vehicleFuelType) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (vehicleFuelType.getCreatedAt() == null)
			vehicleFuelType.setCreatedAt(currentTimestamp);
		vehicleFuelType.setUpdatedAt(currentTimestamp);
		return vehicleFuelTypeRepository.save(vehicleFuelType);
	}

	public String deleteOneVehicleFuelType(VehicleFuelType vehicleFuelType) {
		String result = null;
		if (vehicleFuelTypeRepository.existsById(vehicleFuelType.getId())) {
			vehicleFuelTypeRepository.delete(vehicleFuelType);
			result = " VehicleFuelType deleted!";
		} else {
			result = "VehicleFuelType Not Found! or Already deleted!";
		}
		return result;
	}
}
