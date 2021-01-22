package com.ajay.security.api.tenant.service;

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

	public String saveVehicleServiceCenter(VehicleServiceCenter vehicleServiceCenter) {
		return vehicleServiceCenterRepository.save(vehicleServiceCenter) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVehicleServiceCenter(VehicleServiceCenter vehicleServiceCenter) {
		return vehicleServiceCenterRepository.save(vehicleServiceCenter) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVehicleServiceCenter(Integer id) {
		vehicleServiceCenterRepository.deleteById(id);
		return " successfully deleted!";
	}
}
