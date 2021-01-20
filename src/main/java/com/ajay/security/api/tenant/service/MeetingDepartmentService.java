package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.MeetingDepartment;
import com.ajay.security.api.tenant.repository.MeetingDepartmentRepository;

@Service
public class MeetingDepartmentService {

	@Autowired
	private MeetingDepartmentRepository meetingDepartmentRepository;

	public List<MeetingDepartment> getAllMeetingDepartments() {
		return meetingDepartmentRepository.findAll();
	}

	public MeetingDepartment getOneMeetingDepartment(Integer id) {
		return meetingDepartmentRepository.findById(id).get();
	}

	public String saveMeetingDepartment(MeetingDepartment meetingDepartment) {
		return meetingDepartmentRepository.save(meetingDepartment) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateMeetingDepartment(MeetingDepartment meetingDepartment) {
		return meetingDepartmentRepository.save(meetingDepartment) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneMeetingDepartment(Integer id) {
		meetingDepartmentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
