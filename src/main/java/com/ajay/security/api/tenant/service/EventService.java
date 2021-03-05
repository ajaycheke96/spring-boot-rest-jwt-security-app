package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Event saveEvent(Event event) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (event.getCreatedAt() == null)
			event.setCreatedAt(currentTimestamp);
		event.setUpdatedAt(currentTimestamp);

		// For EventBatches list
		if (!event.getEventBatches().isEmpty())
			event.getEventBatches().forEach(eventBatch -> {
				if (eventBatch.getCreatedAt() == null)
					eventBatch.setCreatedAt(currentTimestamp);
				eventBatch.setUpdatedAt(currentTimestamp);
			});

		// For EventDepartments list
		if (!event.getEventDepartments().isEmpty())
			event.getEventDepartments().forEach(eventDepartment -> {
				if (eventDepartment.getCreatedAt() == null)
					eventDepartment.setCreatedAt(currentTimestamp);
				eventDepartment.setUpdatedAt(currentTimestamp);
			});

		// For EventEmployeeCategories list
		if (!event.getEventEmployeeCategories().isEmpty())
			event.getEventEmployeeCategories().forEach(eventEmployeeCategory -> {
				if (eventEmployeeCategory.getCreatedAt() == null)
					eventEmployeeCategory.setCreatedAt(currentTimestamp);
				eventEmployeeCategory.setUpdatedAt(currentTimestamp);
			});

		// For EventTypeBean object
		if (event.getEventTypeBean() != null) {
			if (event.getEventTypeBean().getCreatedAt() == null)
				event.getEventTypeBean().setCreatedAt(currentTimestamp);
			event.getEventTypeBean().setUpdatedAt(currentTimestamp);
		}

		return eventRepository.save(event);
	}

	public String deleteOneEvent(Event event) {
		String result = null;
		if (eventRepository.existsById(event.getId())) {
			eventRepository.delete(event);
			result = " Event deleted!";
		} else {
			result = "Event Not Found! or Already deleted!";
		}
		return result;
	}
}
