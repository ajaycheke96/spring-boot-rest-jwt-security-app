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

import com.ajay.security.api.tenant.entity.Course;
import com.ajay.security.api.tenant.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/all")
	public List<Course> getAllCourse() {
		return courseService.getAllCourses();
	}

	@GetMapping("/one/{id}")
	public Course getOneCourse(@PathVariable Integer id) {
		return courseService.getOneCourse(id);
	}

	@PostMapping("/save")
	public String saveCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}

	@PutMapping("/update")
	public String updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCourse(@PathVariable Integer id) {
		return courseService.deleteOneCourse(id);
	}
}
