package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public VehicleLog saveVehicleLog(VehicleLog vehicleLog) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (vehicleLog.getCreatedAt() == null)
			vehicleLog.setCreatedAt(currentTimestamp);
		vehicleLog.setUpdatedAt(currentTimestamp);
		return vehicleLogRepository.save(vehicleLog);
	}

	public String deleteOneVehicleLog(VehicleLog vehicleLog) {
		String result = null;
		if (vehicleLogRepository.existsById(vehicleLog.getId())) {
			vehicleLogRepository.delete(vehicleLog);
			result = " VehicleLog deleted!";
		} else {
			result = "VehicleLog Not Found! or Already deleted!";
		}
		return result;
	}
}
