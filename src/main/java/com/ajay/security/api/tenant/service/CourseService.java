package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Course;
import com.ajay.security.api.tenant.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course getOneCourse(Integer id) {
		return courseRepository.findById(id).get();
	}

	public String saveCourse(Course course) {
		return courseRepository.save(course) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateCourse(Course course) {
		return courseRepository.save(course) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneCourse(Integer id) {
		courseRepository.deleteById(id);
		return " successfully deleted!";
	}
}
