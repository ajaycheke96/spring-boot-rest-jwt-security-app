package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public CourseGroup saveCourseGroup(CourseGroup courseGroup) {
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		if (courseGroup.getCreatedAt() == null)
			courseGroup.setCreatedAt(currentTimeStamp);
		courseGroup.setUpdatedAt(currentTimeStamp);
		return courseGroupRepository.save(courseGroup);
	}

	public String deleteOneCourseGroup(CourseGroup courseGroup) {
		String result = null;
		if (courseGroupRepository.existsById(courseGroup.getId())) {
			courseGroupRepository.delete(courseGroup);
			result = " CourseGroup deleted!";
		} else {
			result = "CourseGroup Not Found! or Already deleted!";
		}
		return result;
	}
}
