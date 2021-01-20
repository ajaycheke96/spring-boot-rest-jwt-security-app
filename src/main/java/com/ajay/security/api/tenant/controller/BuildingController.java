package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.Building;
import com.ajay.security.api.tenant.service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@GetMapping("/all")
	public List<Building> getAllBuilding() {
		return buildingService.getAllBuildings();
	}

	@GetMapping("/one/{id}")
	public Building getOneBuilding(@PathVariable Integer id) {
		return buildingService.getOneBuilding(id);
	}

	@PostMapping("/save")
	public String saveBuilding(@RequestBody Building building) {
		return buildingService.saveBuilding(building);
	}

	@PutMapping("/update")
	public String updateBuilding(@RequestBody Building building) {
		return buildingService.updateBuilding(building);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBuilding(@PathVariable Integer id) {
		return buildingService.deleteOneBuilding(id);
	}
}
