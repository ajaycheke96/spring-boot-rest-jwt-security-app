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

import com.ajay.security.api.tenant.entity.EventCourse;
import com.ajay.security.api.tenant.service.EventCourseService;

@RestController
@RequestMapping("/eventCourse")
public class EventCourseController {

	@Autowired
	private EventCourseService eventCourseService;

	@GetMapping("/all")
	public List<EventCourse> getAllEventCourse() {
		return eventCourseService.getAllEventCourses();
	}

	@GetMapping("/one/{id}")
	public EventCourse getOneEventCourse(@PathVariable Integer id) {
		return eventCourseService.getOneEventCourse(id);
	}

	@PostMapping("/save")
	public String saveEventCourse(@RequestBody EventCourse eventCourse) {
		return eventCourseService.saveEventCourse(eventCourse);
	}

	@PutMapping("/update")
	public String updateEventCourse(@RequestBody EventCourse eventCourse) {
		return eventCourseService.updateEventCourse(eventCourse);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEventCourse(@PathVariable Integer id) {
		return eventCourseService.deleteOneEventCourse(id);
	}
}
