package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VehicleServiceRecord;
import com.ajay.security.api.tenant.repository.VehicleServiceRecordRepository;

@Service
@Transactional
public class VehicleServiceRecordService {

	@Autowired
	private VehicleServiceRecordRepository vehicleServiceRecordRepository;

	public List<VehicleServiceRecord> getAllVehicleServiceRecords() {
		return vehicleServiceRecordRepository.findAll();
	}

	public VehicleServiceRecord getOneVehicleServiceRecord(Integer id) {
		return vehicleServiceRecordRepository.findById(id).get();
	}

	public String saveVehicleServiceRecord(VehicleServiceRecord vehicleServiceRecord) {
		return vehicleServiceRecordRepository.save(vehicleServiceRecord) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVehicleServiceRecord(VehicleServiceRecord vehicleServiceRecord) {
		return vehicleServiceRecordRepository.save(vehicleServiceRecord) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVehicleServiceRecord(Integer id) {
		vehicleServiceRecordRepository.deleteById(id);
		return " successfully deleted!";
	}
}
