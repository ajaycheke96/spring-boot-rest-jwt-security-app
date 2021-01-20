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

import com.ajay.security.api.tenant.entity.MeetingDepartment;
import com.ajay.security.api.tenant.service.MeetingDepartmentService;

@RestController
@RequestMapping("/meetingDepartment")
public class MeetingDepartmentController {

	@Autowired
	private MeetingDepartmentService meetingDepartmentService;

	@GetMapping("/all")
	public List<MeetingDepartment> getAllMeetingDepartment() {
		return meetingDepartmentService.getAllMeetingDepartments();
	}

	@GetMapping("/one/{id}")
	public MeetingDepartment getOneMeetingDepartment(@PathVariable Integer id) {
		return meetingDepartmentService.getOneMeetingDepartment(id);
	}

	@PostMapping("/save")
	public String saveMeetingDepartment(@RequestBody MeetingDepartment meetingDepartment) {
		return meetingDepartmentService.saveMeetingDepartment(meetingDepartment);
	}

	@PutMapping("/update")
	public String updateMeetingDepartment(@RequestBody MeetingDepartment meetingDepartment) {
		return meetingDepartmentService.updateMeetingDepartment(meetingDepartment);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneMeetingDepartment(@PathVariable Integer id) {
		return meetingDepartmentService.deleteOneMeetingDepartment(id);
	}
}
