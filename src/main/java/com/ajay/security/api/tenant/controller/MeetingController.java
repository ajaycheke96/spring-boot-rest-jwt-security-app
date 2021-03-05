package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Meeting;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.MeetingService;

@RestController
@RequestMapping("/meeting")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	@GetMapping("/listAllMeeting")
	public ApiResponse getAllMeeting() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Meeting", meetingService.getAllMeetings());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Meeting Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneMeeting(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Meeting", meetingService.getOneMeeting(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Meeting Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveMeeting")
	public ApiResponse saveMeeting(@RequestBody Meeting meeting) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Meeting saved!",
					meetingService.saveMeeting(meeting));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Meeting Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateMeeting")
	public ApiResponse updateMeeting(@RequestBody Meeting meeting) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Meeting updated!",
					meetingService.saveMeeting(meeting));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Meeting Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteMeeting")
	public ApiResponse deleteOneMeeting(@RequestBody Meeting meeting) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, meetingService.deleteOneMeeting(meeting), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Meeting Service exception : " + e.getLocalizedMessage());
		}
	}
}
