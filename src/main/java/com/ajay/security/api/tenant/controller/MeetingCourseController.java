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

import com.ajay.security.api.tenant.entity.MeetingCourse;
import com.ajay.security.api.tenant.service.MeetingCourseService;

@RestController
@RequestMapping("/meetingCourse")
public class MeetingCourseController {

	@Autowired
	private MeetingCourseService meetingCourseService;

	@GetMapping("/all")
	public List<MeetingCourse> getAllMeetingCourse() {
		return meetingCourseService.getAllMeetingCourses();
	}

	@GetMapping("/one/{id}")
	public MeetingCourse getOneMeetingCourse(@PathVariable Integer id) {
		return meetingCourseService.getOneMeetingCourse(id);
	}

	@PostMapping("/save")
	public String saveMeetingCourse(@RequestBody MeetingCourse meetingCourse) {
		return meetingCourseService.saveMeetingCourse(meetingCourse);
	}

	@PutMapping("/update")
	public String updateMeetingCourse(@RequestBody MeetingCourse meetingCourse) {
		return meetingCourseService.updateMeetingCourse(meetingCourse);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneMeetingCourse(@PathVariable Integer id) {
		return meetingCourseService.deleteOneMeetingCourse(id);
	}
}
