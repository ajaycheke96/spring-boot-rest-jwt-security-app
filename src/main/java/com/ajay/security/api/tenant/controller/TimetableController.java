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

import com.ajay.security.api.tenant.entity.Timetable;
import com.ajay.security.api.tenant.service.TimetableService;

@RestController
@RequestMapping("/timetable")
public class TimetableController {

	@Autowired
	private TimetableService timetableService;

	@GetMapping("/all")
	public List<Timetable> getAllTimetable() {
		return timetableService.getAllTimetables();
	}

	@GetMapping("/one/{id}")
	public Timetable getOneTimetable(@PathVariable Integer id) {
		return timetableService.getOneTimetable(id);
	}

	@PostMapping("/save")
	public String saveTimetable(@RequestBody Timetable timetable) {
		return timetableService.saveTimetable(timetable);
	}

	@PutMapping("/update")
	public String updateTimetable(@RequestBody Timetable timetable) {
		return timetableService.updateTimetable(timetable);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTimetable(@PathVariable Integer id) {
		return timetableService.deleteOneTimetable(id);
	}
}
