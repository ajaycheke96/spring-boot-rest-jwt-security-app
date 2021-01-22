package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Vehicle;
import com.ajay.security.api.tenant.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	public Vehicle getOneVehicle(Integer id) {
		return vehicleRepository.findById(id).get();
	}

	public String saveVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneVehicle(Integer id) {
		vehicleRepository.deleteById(id);
		return " successfully deleted!";
	}
}
