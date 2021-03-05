package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.VehicleIncharge;
import com.ajay.security.api.tenant.repository.VehicleInchargeRepository;

@RestController
@RequestMapping("/vehicleIncharge")
public class VehicleInchargeService {

	@Autowired
	private VehicleInchargeRepository vehicleInchargeRepository;

	public List<VehicleIncharge> getAllVehicleIncharges() {
		return vehicleInchargeRepository.findAll();
	}

	public VehicleIncharge getOneVehicleIncharge(Integer id) {
		return vehicleInchargeRepository.findById(id).get();
	}

	public VehicleIncharge saveVehicleIncharge(VehicleIncharge vehicleIncharge) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (vehicleIncharge.getCreatedAt() == null)
			vehicleIncharge.setCreatedAt(currentTimestamp);
		vehicleIncharge.setUpdatedAt(currentTimestamp);
		return vehicleInchargeRepository.save(vehicleIncharge);
	}

	public String deleteOneVehicleIncharge(VehicleIncharge vehicleIncharge) {
		String result = null;
		if (vehicleInchargeRepository.existsById(vehicleIncharge.getId())) {
			vehicleInchargeRepository.delete(vehicleIncharge);
			result = " VehicleIncharge deleted!";
		} else {
			result = "VehicleIncharge Not Found! or Already deleted!";
		}
		return result;
	}
}
