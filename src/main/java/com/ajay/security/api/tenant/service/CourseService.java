package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Course saveCourse(Course course) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (course.getCreatedAt() == null)
			course.setCreatedAt(currentTimestamp);
		course.setUpdatedAt(currentTimestamp);
		return courseRepository.save(course);
	}

	public String deleteOneCourse(Course course) {
		courseRepository.delete(course);
		return " successfully deleted!";
	}
}
