package com.ajay.security.api.tenant.service;

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

	public String saveVehicleFuelType(VehicleFuelType vehicleFuelType) {
		return vehicleFuelTypeRepository.save(vehicleFuelType) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVehicleFuelType(VehicleFuelType vehicleFuelType) {
		return vehicleFuelTypeRepository.save(vehicleFuelType) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVehicleFuelType(Integer id) {
		vehicleFuelTypeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
