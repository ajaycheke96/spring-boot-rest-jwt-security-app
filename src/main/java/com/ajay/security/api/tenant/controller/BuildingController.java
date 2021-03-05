package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Building;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.BuildingService;

@RestController
@RequestMapping("/building")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@GetMapping("/listAllBuilding")
	public ApiResponse getAllBuilding() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Building",
					buildingService.getAllBuildings());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Building Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneBuilding(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Building", buildingService.getOneBuilding(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Building Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveBuilding")
	public ApiResponse saveBuilding(@RequestBody Building building) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Building saved!",
					buildingService.saveBuilding(building));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Building Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateBuilding")
	public ApiResponse updateBuilding(@RequestBody Building building) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Building updated!",
					buildingService.saveBuilding(building));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Building Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteBuilding")
	public ApiResponse deleteOneBuilding(@RequestBody Building building) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, buildingService.deleteOneBuilding(building), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Building Service exception : " + e.getLocalizedMessage());
		}
	}
}
