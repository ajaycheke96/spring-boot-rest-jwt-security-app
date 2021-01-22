package com.ajay.security.api.tenant.service;

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

	public String saveVehiclePerformanceCriteria(VehiclePerformanceCriteria vehiclePerformanceCriteria) {
		return vehiclePerformanceCriteriaRepository.save(vehiclePerformanceCriteria) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVehiclePerformanceCriteria(VehiclePerformanceCriteria vehiclePerformanceCriteria) {
		return vehiclePerformanceCriteriaRepository.save(vehiclePerformanceCriteria) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVehiclePerformanceCriteria(Integer id) {
		vehiclePerformanceCriteriaRepository.deleteById(id);
		return " successfully deleted!";
	}
}
