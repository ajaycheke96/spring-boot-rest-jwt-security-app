package com.ajay.security.api.tenant.service;

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

	public String saveBuilding(Building building) {
		return buildingRepository.save(building) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBuilding(Building building) {
		return buildingRepository.save(building) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBuilding(Integer id) {
		buildingRepository.deleteById(id);
		return " successfully deleted!";
	}
}
