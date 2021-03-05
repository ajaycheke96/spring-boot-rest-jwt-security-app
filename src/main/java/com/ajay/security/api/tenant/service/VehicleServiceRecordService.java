package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public VehicleServiceRecord saveVehicleServiceRecord(VehicleServiceRecord vehicleServiceRecord) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (vehicleServiceRecord.getCreatedAt() == null)
			vehicleServiceRecord.setCreatedAt(currentTimestamp);
		vehicleServiceRecord.setUpdatedAt(currentTimestamp);
		return vehicleServiceRecordRepository.save(vehicleServiceRecord);
	}

	public String deleteOneVehicleServiceRecord(VehicleServiceRecord vehicleServiceRecord) {
		String result = null;
		if (vehicleServiceRecordRepository.existsById(vehicleServiceRecord.getId())) {
			vehicleServiceRecordRepository.delete(vehicleServiceRecord);
			result = " VehicleServiceRecord deleted!";
		} else {
			result = "VehicleServiceRecord Not Found! or Already deleted!";
		}
		return result;
	}
}
