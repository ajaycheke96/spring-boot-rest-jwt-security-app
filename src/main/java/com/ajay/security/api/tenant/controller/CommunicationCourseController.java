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

import com.ajay.security.api.tenant.entity.CommunicationCourse;
import com.ajay.security.api.tenant.service.CommunicationCourseService;

@RestController
@RequestMapping("/communicationCourse")
public class CommunicationCourseController {

	@Autowired
	private CommunicationCourseService communicationCourseService;

	@GetMapping("/all")
	public List<CommunicationCourse> getAllCommunicationCourse() {
		return communicationCourseService.getAllCommunicationCourses();
	}

	@GetMapping("/one/{id}")
	public CommunicationCourse getOneCommunicationCourse(@PathVariable Integer id) {
		return communicationCourseService.getOneCommunicationCourse(id);
	}

	@PostMapping("/save")
	public String saveCommunicationCourse(@RequestBody CommunicationCourse communicationCourse) {
		return communicationCourseService.saveCommunicationCourse(communicationCourse);
	}

	@PutMapping("/update")
	public String updateCommunicationCourse(@RequestBody CommunicationCourse communicationCourse) {
		return communicationCourseService.updateCommunicationCourse(communicationCourse);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCommunicationCourse(@PathVariable Integer id) {
		return communicationCourseService.deleteOneCommunicationCourse(id);
	}
}
