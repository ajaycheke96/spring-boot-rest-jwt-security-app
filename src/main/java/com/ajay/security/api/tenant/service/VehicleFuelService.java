package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VehicleFuel;
import com.ajay.security.api.tenant.repository.VehicleFuelRepository;

@Service
@Transactional
public class VehicleFuelService {

	@Autowired
	private VehicleFuelRepository vehicleFuelRepository;

	public List<VehicleFuel> getAllVehicleFuels() {
		return vehicleFuelRepository.findAll();
	}

	public VehicleFuel getOneVehicleFuel(Integer id) {
		return vehicleFuelRepository.findById(id).get();
	}

	public String saveVehicleFuel(VehicleFuel vehicleFuel) {
		return vehicleFuelRepository.save(vehicleFuel) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateVehicleFuel(VehicleFuel vehicleFuel) {
		return vehicleFuelRepository.save(vehicleFuel) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVehicleFuel(Integer id) {
		vehicleFuelRepository.deleteById(id);
		return " successfully deleted!";
	}
}
