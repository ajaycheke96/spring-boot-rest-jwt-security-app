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

import com.ajay.security.api.tenant.entity.TimetableAllocationDetail;
import com.ajay.security.api.tenant.service.TimetableAllocationDetailService;

@RestController
@RequestMapping("/timetableAllocationDetail")
public class TimetableAllocationDetailController {

	@Autowired
	private TimetableAllocationDetailService timetableAllocationDetailService;

	@GetMapping("/all")
	public List<TimetableAllocationDetail> getAllTimetableAllocationDetail() {
		return timetableAllocationDetailService.getAllTimetableAllocationDetails();
	}

	@GetMapping("/one/{id}")
	public TimetableAllocationDetail getOneTimetableAllocationDetail(@PathVariable Integer id) {
		return timetableAllocationDetailService.getOneTimetableAllocationDetail(id);
	}

	@PostMapping("/save")
	public String saveTimetableAllocationDetail(@RequestBody TimetableAllocationDetail timetableAllocationDetail) {
		return timetableAllocationDetailService.saveTimetableAllocationDetail(timetableAllocationDetail);
	}

	@PutMapping("/update")
	public String updateTimetableAllocationDetail(@RequestBody TimetableAllocationDetail timetableAllocationDetail) {
		return timetableAllocationDetailService.updateTimetableAllocationDetail(timetableAllocationDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTimetableAllocationDetail(@PathVariable Integer id) {
		return timetableAllocationDetailService.deleteOneTimetableAllocationDetail(id);
	}
}
