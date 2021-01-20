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

import com.ajay.security.api.tenant.entity.EventType;
import com.ajay.security.api.tenant.service.EventTypeService;

@RestController
@RequestMapping("/eventType")
public class EventTypeController {

	@Autowired
	private EventTypeService eventTypeService;

	@GetMapping("/all")
	public List<EventType> getAllEventType() {
		return eventTypeService.getAllEventTypes();
	}

	@GetMapping("/one/{id}")
	public EventType getOneEventType(@PathVariable Integer id) {
		return eventTypeService.getOneEventType(id);
	}

	@PostMapping("/save")
	public String saveEventType(@RequestBody EventType eventType) {
		return eventTypeService.saveEventType(eventType);
	}

	@PutMapping("/update")
	public String updateEventType(@RequestBody EventType eventType) {
		return eventTypeService.updateEventType(eventType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEventType(@PathVariable Integer id) {
		return eventTypeService.deleteOneEventType(id);
	}
}
