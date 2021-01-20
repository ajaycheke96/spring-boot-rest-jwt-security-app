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

import com.ajay.security.api.tenant.entity.EventDepartment;
import com.ajay.security.api.tenant.service.EventDepartmentService;

@RestController
@RequestMapping("/eventDepartment")
public class EventDepartmentController {

	@Autowired
	private EventDepartmentService eventDepartmentService;

	@GetMapping("/all")
	public List<EventDepartment> getAllEventDepartment() {
		return eventDepartmentService.getAllEventDepartments();
	}

	@GetMapping("/one/{id}")
	public EventDepartment getOneEventDepartment(@PathVariable Integer id) {
		return eventDepartmentService.getOneEventDepartment(id);
	}

	@PostMapping("/save")
	public String saveEventDepartment(@RequestBody EventDepartment eventDepartment) {
		return eventDepartmentService.saveEventDepartment(eventDepartment);
	}

	@PutMapping("/update")
	public String updateEventDepartment(@RequestBody EventDepartment eventDepartment) {
		return eventDepartmentService.updateEventDepartment(eventDepartment);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEventDepartment(@PathVariable Integer id) {
		return eventDepartmentService.deleteOneEventDepartment(id);
	}
}
