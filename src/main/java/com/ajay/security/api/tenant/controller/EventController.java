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

import com.ajay.security.api.tenant.entity.Event;
import com.ajay.security.api.tenant.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping("/all")
	public List<Event> getAllEvent() {
		return eventService.getAllEvents();
	}

	@GetMapping("/one/{id}")
	public Event getOneEvent(@PathVariable Integer id) {
		return eventService.getOneEvent(id);
	}

	@PostMapping("/save")
	public String saveEvent(@RequestBody Event event) {
		return eventService.saveEvent(event);
	}

	@PutMapping("/update")
	public String updateEvent(@RequestBody Event event) {
		return eventService.updateEvent(event);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEvent(@PathVariable Integer id) {
		return eventService.deleteOneEvent(id);
	}
}
