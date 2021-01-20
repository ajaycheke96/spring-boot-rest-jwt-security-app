package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.MeetingEmployee;
import com.ajay.security.api.tenant.repository.MeetingEmployeeRepository;

@Service
@Transactional
public class MeetingEmployeeService {

	@Autowired
	private MeetingEmployeeRepository meetingEmployeeRepository;

	public List<MeetingEmployee> getAllMeetingEmployees() {
		return meetingEmployeeRepository.findAll();
	}

	public MeetingEmployee getOneMeetingEmployee(Integer id) {
		return meetingEmployeeRepository.findById(id).get();
	}

	public String saveMeetingEmployee(MeetingEmployee meetingEmployee) {
		return meetingEmployeeRepository.save(meetingEmployee) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateMeetingEmployee(MeetingEmployee meetingEmployee) {
		return meetingEmployeeRepository.save(meetingEmployee) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneMeetingEmployee(Integer id) {
		meetingEmployeeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
