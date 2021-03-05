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

import com.ajay.security.api.tenant.entity.Event;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EventService;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping("/listAllEvent")
	public ApiResponse getAllEvent() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Event", eventService.getAllEvents());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Event" + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEvent(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Event", eventService.getOneEvent(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Event" + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEvent")
	public ApiResponse saveEvent(@RequestBody Event event) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Event saved!", eventService.saveEvent(event));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Event" + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEvent")
	public ApiResponse updateEvent(@RequestBody Event event) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Event updated!", eventService.saveEvent(event));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Event" + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEvent")
	public ApiResponse deleteOneEvent(@RequestBody Event event) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, eventService.deleteOneEvent(event), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Event" + e.getLocalizedMessage());
		}
	}
}
