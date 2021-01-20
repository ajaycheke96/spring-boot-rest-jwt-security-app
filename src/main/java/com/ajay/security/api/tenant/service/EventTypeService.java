package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EventType;
import com.ajay.security.api.tenant.repository.EventTypeRepository;

@Service
@Transactional
public class EventTypeService {

	@Autowired
	private EventTypeRepository eventTypeRepository;

	public List<EventType> getAllEventTypes() {
		return eventTypeRepository.findAll();
	}

	public EventType getOneEventType(Integer id) {
		return eventTypeRepository.findById(id).get();
	}

	public String saveEventType(EventType eventType) {
		return eventTypeRepository.save(eventType) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEventType(EventType eventType) {
		return eventTypeRepository.save(eventType) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneEventType(Integer id) {
		eventTypeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
