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

import com.ajay.security.api.tenant.entity.MeetingEmployeeCategory;
import com.ajay.security.api.tenant.service.MeetingEmployeeCategoryService;

@RestController
@RequestMapping("/meetingEmployeeCategory")
public class MeetingEmployeeCategoryController {

	@Autowired
	private MeetingEmployeeCategoryService meetingEmployeeCategoryService;

	@GetMapping("/all")
	public List<MeetingEmployeeCategory> getAllMeetingEmployeeCategory() {
		return meetingEmployeeCategoryService.getAllMeetingEmployeeCategorys();
	}

	@GetMapping("/one/{id}")
	public MeetingEmployeeCategory getOneMeetingEmployeeCategory(@PathVariable Integer id) {
		return meetingEmployeeCategoryService.getOneMeetingEmployeeCategory(id);
	}

	@PostMapping("/save")
	public String saveMeetingEmployeeCategory(@RequestBody MeetingEmployeeCategory meetingEmployeeCategory) {
		return meetingEmployeeCategoryService.saveMeetingEmployeeCategory(meetingEmployeeCategory);
	}

	@PutMapping("/update")
	public String updateMeetingEmployeeCategory(@RequestBody MeetingEmployeeCategory meetingEmployeeCategory) {
		return meetingEmployeeCategoryService.updateMeetingEmployeeCategory(meetingEmployeeCategory);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneMeetingEmployeeCategory(@PathVariable Integer id) {
		return meetingEmployeeCategoryService.deleteOneMeetingEmployeeCategory(id);
	}
}
