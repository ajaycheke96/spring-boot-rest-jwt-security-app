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

import com.ajay.security.api.tenant.entity.MeetingEmployee;
import com.ajay.security.api.tenant.service.MeetingEmployeeService;

@RestController
@RequestMapping("/meetingEmployee")
public class MeetingEmployeeController {

	@Autowired
	private MeetingEmployeeService meetingEmployeeService;

	@GetMapping("/all")
	public List<MeetingEmployee> getAllMeetingEmployee() {
		return meetingEmployeeService.getAllMeetingEmployees();
	}

	@GetMapping("/one/{id}")
	public MeetingEmployee getOneMeetingEmployee(@PathVariable Integer id) {
		return meetingEmployeeService.getOneMeetingEmployee(id);
	}

	@PostMapping("/save")
	public String saveMeetingEmployee(@RequestBody MeetingEmployee meetingEmployee) {
		return meetingEmployeeService.saveMeetingEmployee(meetingEmployee);
	}

	@PutMapping("/update")
	public String updateMeetingEmployee(@RequestBody MeetingEmployee meetingEmployee) {
		return meetingEmployeeService.updateMeetingEmployee(meetingEmployee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneMeetingEmployee(@PathVariable Integer id) {
		return meetingEmployeeService.deleteOneMeetingEmployee(id);
	}
}
