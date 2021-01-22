package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VehicleLog;
import com.ajay.security.api.tenant.repository.VehicleLogRepository;

@Service
@Transactional
public class VehicleLogService {

	@Autowired
	private VehicleLogRepository vehicleLogRepository;

	public List<VehicleLog> getAllVehicleLogs() {
		return vehicleLogRepository.findAll();
	}

	public VehicleLog getOneVehicleLog(Integer id) {
		return vehicleLogRepository.findById(id).get();
	}

	public String saveVehicleLog(VehicleLog vehicleLog) {
		return vehicleLogRepository.save(vehicleLog) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateVehicleLog(VehicleLog vehicleLog) {
		return vehicleLogRepository.save(vehicleLog) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneVehicleLog(Integer id) {
		vehicleLogRepository.deleteById(id);
		return " successfully deleted!";
	}
}
