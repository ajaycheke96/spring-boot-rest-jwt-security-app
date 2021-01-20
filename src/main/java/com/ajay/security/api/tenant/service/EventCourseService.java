package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EventCourse;
import com.ajay.security.api.tenant.repository.EventCourseRepository;

@Service
@Transactional
public class EventCourseService {

	@Autowired
	private EventCourseRepository eventCourseRepository;

	public List<EventCourse> getAllEventCourses() {
		return eventCourseRepository.findAll();
	}

	public EventCourse getOneEventCourse(Integer id) {
		return eventCourseRepository.findById(id).get();
	}

	public String saveEventCourse(EventCourse eventCourse) {
		return eventCourseRepository.save(eventCourse) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEventCourse(EventCourse eventCourse) {
		return eventCourseRepository.save(eventCourse) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEventCourse(Integer id) {
		eventCourseRepository.deleteById(id);
		return " successfully deleted!";
	}
}
