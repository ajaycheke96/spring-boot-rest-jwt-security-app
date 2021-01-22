package com.ajay.security.api.tenant.service;

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

	public String saveVehicleIncharge(VehicleIncharge vehicleIncharge) {
		return vehicleInchargeRepository.save(vehicleIncharge) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVehicleIncharge(VehicleIncharge vehicleIncharge) {
		return vehicleInchargeRepository.save(vehicleIncharge) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVehicleIncharge(Integer id) {
		vehicleInchargeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
