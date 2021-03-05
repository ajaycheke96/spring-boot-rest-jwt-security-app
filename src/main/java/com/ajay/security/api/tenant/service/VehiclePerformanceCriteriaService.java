package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VehiclePerformanceCriteria;
import com.ajay.security.api.tenant.repository.VehiclePerformanceCriteriaRepository;

@Service
@Transactional
public class VehiclePerformanceCriteriaService {

	@Autowired
	private VehiclePerformanceCriteriaRepository vehiclePerformanceCriteriaRepository;

	public List<VehiclePerformanceCriteria> getAllVehiclePerformanceCriterias() {
		return vehiclePerformanceCriteriaRepository.findAll();
	}

	public VehiclePerformanceCriteria getOneVehiclePerformanceCriteria(Integer id) {
		return vehiclePerformanceCriteriaRepository.findById(id).get();
	}

	public VehiclePerformanceCriteria saveVehiclePerformanceCriteria(
			VehiclePerformanceCriteria vehiclePerformanceCriteria) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (vehiclePerformanceCriteria.getCreatedAt() == null)
			vehiclePerformanceCriteria.setCreatedAt(currentTimestamp);
		vehiclePerformanceCriteria.setUpdatedAt(currentTimestamp);
		return vehiclePerformanceCriteriaRepository.save(vehiclePerformanceCriteria);
	}

	public String deleteOneVehiclePerformanceCriteria(VehiclePerformanceCriteria vehiclePerformanceCriteria) {
		String result = null;
		if (vehiclePerformanceCriteriaRepository.existsById(vehiclePerformanceCriteria.getId())) {
			vehiclePerformanceCriteriaRepository.delete(vehiclePerformanceCriteria);
			result = " VehiclePerformanceCriteria deleted!";
		} else {
			result = "VehiclePerformanceCriteria Not Found! or Already deleted!";
		}
		return result;
	}
}
