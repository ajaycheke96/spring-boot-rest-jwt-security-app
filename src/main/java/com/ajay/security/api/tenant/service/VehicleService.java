package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Vehicle;
import com.ajay.security.api.tenant.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	public Vehicle getOneVehicle(Integer id) {
		return vehicleRepository.findById(id).get();
	}

	public Vehicle saveVehicle(Vehicle vehicle) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (vehicle.getCreatedAt() == null)
			vehicle.setCreatedAt(currentTimestamp);
		vehicle.setUpdatedAt(currentTimestamp);

		// set VehicleDocuments
		if (!vehicle.getVehicleDocuments().isEmpty())
			vehicle.getVehicleDocuments().forEach(vehicleDocument -> {
				if (vehicleDocument.getCreatedAt() == null)
					vehicleDocument.setCreatedAt(currentTimestamp);
				vehicleDocument.setUpdatedAt(currentTimestamp);
			});

		// set VehicleFuels
		if (!vehicle.getVehicleFuels().isEmpty())
			vehicle.getVehicleFuels().forEach(vehicleFuel -> {
				if (vehicleFuel.getCreatedAt() == null)
					vehicleFuel.setCreatedAt(currentTimestamp);
				vehicleFuel.setUpdatedAt(currentTimestamp);
			});

//		// set VehicleIncharges
//		if (!vehicle.getVehicleIncharges().isEmpty())
//			vehicle.getVehicleIncharges().forEach(vehicleIncharge -> {
//				if (vehicleIncharge.getCreatedAt() == null)
//					vehicleIncharge.setCreatedAt(currentTimestamp);
//				vehicleIncharge.setUpdatedAt(currentTimestamp);
//			});

		// set VehicleLogs here

		// set VehiclePerformanceCriterias here

		return vehicleRepository.save(vehicle);
	}

	public String deleteOneVehicle(Vehicle vehicle) {
		String result = null;
		if (vehicleRepository.existsById(vehicle.getId())) {
			vehicleRepository.delete(vehicle);
			result = " Vehicle deleted!";
		} else {
			result = "Vehicle Not Found! or Already deleted!";
		}
		return result;
	}
}
