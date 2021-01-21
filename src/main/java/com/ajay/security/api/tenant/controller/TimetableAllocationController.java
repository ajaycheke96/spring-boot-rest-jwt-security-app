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

import com.ajay.security.api.tenant.entity.TimetableAllocation;
import com.ajay.security.api.tenant.service.TimetableAllocationService;

@RestController
@RequestMapping("/timetableAllocation")
public class TimetableAllocationController {

	@Autowired
	private TimetableAllocationService timetableAllocationService;

	@GetMapping("/all")
	public List<TimetableAllocation> getAllTimetableAllocation() {
		return timetableAllocationService.getAllTimetableAllocations();
	}

	@GetMapping("/one/{id}")
	public TimetableAllocation getOneTimetableAllocation(@PathVariable Integer id) {
		return timetableAllocationService.getOneTimetableAllocation(id);
	}

	@PostMapping("/save")
	public String saveTimetableAllocation(@RequestBody TimetableAllocation timetableAllocation) {
		return timetableAllocationService.saveTimetableAllocation(timetableAllocation);
	}

	@PutMapping("/update")
	public String updateTimetableAllocation(@RequestBody TimetableAllocation timetableAllocation) {
		return timetableAllocationService.updateTimetableAllocation(timetableAllocation);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTimetableAllocation(@PathVariable Integer id) {
		return timetableAllocationService.deleteOneTimetableAllocation(id);
	}
}
