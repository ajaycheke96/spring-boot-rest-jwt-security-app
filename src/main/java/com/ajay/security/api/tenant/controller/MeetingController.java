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

import com.ajay.security.api.tenant.entity.Meeting;
import com.ajay.security.api.tenant.service.MeetingService;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	@GetMapping("/all")
	public List<Meeting> getAllMeeting() {
		return meetingService.getAllMeetings();
	}

	@GetMapping("/one/{id}")
	public Meeting getOneMeeting(@PathVariable Integer id) {
		return meetingService.getOneMeeting(id);
	}

	@PostMapping("/save")
	public String saveMeeting(@RequestBody Meeting meeting) {
		return meetingService.saveMeeting(meeting);
	}

	@PutMapping("/update")
	public String updateMeeting(@RequestBody Meeting meeting) {
		return meetingService.updateMeeting(meeting);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneMeeting(@PathVariable Integer id) {
		return meetingService.deleteOneMeeting(id);
	}
}
