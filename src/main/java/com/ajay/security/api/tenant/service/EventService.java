package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Event;
import com.ajay.security.api.tenant.repository.EventRepository;

@Service
@Transactional
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	public Event getOneEvent(Integer id) {
		return eventRepository.findById(id).get();
	}

	public String saveEvent(Event event) {
		return eventRepository.save(event) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEvent(Event event) {
		return eventRepository.save(event) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneEvent(Integer id) {
		eventRepository.deleteById(id);
		return " successfully deleted!";
	}
}
