package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Building;
import com.ajay.security.api.tenant.repository.BuildingRepository;

@Service
public class BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	public List<Building> getAllBuildings() {
		return buildingRepository.findAll();
	}

	public Building getOneBuilding(Integer id) {
		return buildingRepository.findById(id).get();
	}

	public Building saveBuilding(Building building) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (building.getCreatedAt() == null)
			building.setCreatedAt(currentTimestamp);
		building.setUpdatedAt(currentTimestamp);

		// For Rooms list
		if (!building.getRooms().isEmpty())
			building.getRooms().forEach(room -> {
				if (room.getCreatedAt() == null)
					room.setCreatedAt(currentTimestamp);
				room.setUpdatedAt(currentTimestamp);

				room.setBuilding(building);

			});

		return buildingRepository.save(building);
	}

	public String deleteOneBuilding(Building building) {
		String result = null;
		if (buildingRepository.existsById(building.getId())) {
			buildingRepository.delete(building);
			result = "Building deleted!";
		} else {
			result = "Building not found! Or Already deleted!";
		}
		return result;
	}
}
