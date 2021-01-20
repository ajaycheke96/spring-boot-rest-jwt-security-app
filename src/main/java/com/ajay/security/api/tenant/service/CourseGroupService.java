package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CourseGroup;
import com.ajay.security.api.tenant.repository.CourseGroupRepository;

@Service
public class CourseGroupService {

	@Autowired
	private CourseGroupRepository courseGroupRepository;

	public List<CourseGroup> getAllCourseGroups() {
		return courseGroupRepository.findAll();
	}

	public CourseGroup getOneCourseGroup(Integer id) {
		return courseGroupRepository.findById(id).get();
	}

	public String saveCourseGroup(CourseGroup courseGroup) {
		return courseGroupRepository.save(courseGroup) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateCourseGroup(CourseGroup courseGroup) {
		return courseGroupRepository.save(courseGroup) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCourseGroup(Integer id) {
		courseGroupRepository.deleteById(id);
		return " successfully deleted!";
	}
}
