package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Course;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/listAllCourse")
	public ApiResponse getAllCourse() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "List of Course", courseService.getAllCourses());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Course Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/{id}")
	public ApiResponse getOneCourse(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Course", courseService.getOneCourse(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Course Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
	public ApiResponse saveCourse(@RequestBody Course course) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Course saved!", courseService.saveCourse(course));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Course Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/updateCourse")
	public ApiResponse updateCourse(@RequestBody Course course) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Course updated!", courseService.saveCourse(course));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Course Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteCourse", method = RequestMethod.POST)
	public ApiResponse deleteOneCourse(@RequestBody Course course) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Course deleted!",
					courseService.deleteOneCourse(course));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Course Service exception : " + e.getLocalizedMessage());
		}
	}
}
