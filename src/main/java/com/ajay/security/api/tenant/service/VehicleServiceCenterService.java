package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VehicleServiceCenter;
import com.ajay.security.api.tenant.repository.VehicleServiceCenterRepository;

@Service
@Transactional
public class VehicleServiceCenterService {

	@Autowired
	private VehicleServiceCenterRepository vehicleServiceCenterRepository;

	public List<VehicleServiceCenter> getAllVehicleServiceCenters() {
		return vehicleServiceCenterRepository.findAll();
	}

	public VehicleServiceCenter getOneVehicleServiceCenter(Integer id) {
		return vehicleServiceCenterRepository.findById(id).get();
	}

	public VehicleServiceCenter saveVehicleServiceCenter(VehicleServiceCenter vehicleServiceCenter) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (vehicleServiceCenter.getCreatedAt() == null)
			vehicleServiceCenter.setCreatedAt(currentTimestamp);
		vehicleServiceCenter.setUpdatedAt(currentTimestamp);
		return vehicleServiceCenterRepository.save(vehicleServiceCenter);
	}

	public String deleteOneVehicleServiceCenter(VehicleServiceCenter vehicleServiceCenter) {
		String result = null;
		if (vehicleServiceCenterRepository.existsById(vehicleServiceCenter.getId())) {
			vehicleServiceCenterRepository.delete(vehicleServiceCenter);
			result = " VehicleServiceCenter deleted!";
		} else {
			result = "VehicleServiceCenter Not Found! or Already deleted!";
		}
		return result;
	}
}
