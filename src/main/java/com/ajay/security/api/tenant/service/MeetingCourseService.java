package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.MeetingCourse;
import com.ajay.security.api.tenant.repository.MeetingCourseRepository;

@Service
@Transactional
public class MeetingCourseService {

	@Autowired
	private MeetingCourseRepository meetingCourseRepository;

	public List<MeetingCourse> getAllMeetingCourses() {
		return meetingCourseRepository.findAll();
	}

	public MeetingCourse getOneMeetingCourse(Integer id) {
		return meetingCourseRepository.findById(id).get();
	}

	public String saveMeetingCourse(MeetingCourse meetingCourse) {
		return meetingCourseRepository.save(meetingCourse) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateMeetingCourse(MeetingCourse meetingCourse) {
		return meetingCourseRepository.save(meetingCourse) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneMeetingCourse(Integer id) {
		meetingCourseRepository.deleteById(id);
		return " successfully deleted!";
	}
}
