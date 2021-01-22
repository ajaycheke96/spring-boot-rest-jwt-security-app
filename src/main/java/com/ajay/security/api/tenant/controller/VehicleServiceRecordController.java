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

import com.ajay.security.api.tenant.entity.VehicleServiceRecord;
import com.ajay.security.api.tenant.service.VehicleServiceRecordService;

@RestController
@RequestMapping("/vehicleServiceRecord")
public class VehicleServiceRecordController {

	@Autowired
	private VehicleServiceRecordService vehicleServiceRecordService;

	@GetMapping("/all")
	public List<VehicleServiceRecord> getAllVehicleServiceRecord() {
		return vehicleServiceRecordService.getAllVehicleServiceRecords();
	}

	@GetMapping("/one/{id}")
	public VehicleServiceRecord getOneVehicleServiceRecord(@PathVariable Integer id) {
		return vehicleServiceRecordService.getOneVehicleServiceRecord(id);
	}

	@PostMapping("/save")
	public String saveVehicleServiceRecord(@RequestBody VehicleServiceRecord vehicleServiceRecord) {
		return vehicleServiceRecordService.saveVehicleServiceRecord(vehicleServiceRecord);
	}

	@PutMapping("/update")
	public String updateVehicleServiceRecord(@RequestBody VehicleServiceRecord vehicleServiceRecord) {
		return vehicleServiceRecordService.updateVehicleServiceRecord(vehicleServiceRecord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVehicleServiceRecord(@PathVariable Integer id) {
		return vehicleServiceRecordService.deleteOneVehicleServiceRecord(id);
	}
}
