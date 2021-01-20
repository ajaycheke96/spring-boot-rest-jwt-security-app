package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.MeetingEmployeeCategory;
import com.ajay.security.api.tenant.repository.MeetingEmployeeCategoryRepository;

@Service
@Transactional
public class MeetingEmployeeCategoryService {

	@Autowired
	private MeetingEmployeeCategoryRepository meetingEmployeeCategoryRepository;

	public List<MeetingEmployeeCategory> getAllMeetingEmployeeCategorys() {
		return meetingEmployeeCategoryRepository.findAll();
	}

	public MeetingEmployeeCategory getOneMeetingEmployeeCategory(Integer id) {
		return meetingEmployeeCategoryRepository.findById(id).get();
	}

	public String saveMeetingEmployeeCategory(MeetingEmployeeCategory meetingEmployeeCategory) {
		return meetingEmployeeCategoryRepository.save(meetingEmployeeCategory) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateMeetingEmployeeCategory(MeetingEmployeeCategory meetingEmployeeCategory) {
		return meetingEmployeeCategoryRepository.save(meetingEmployeeCategory) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneMeetingEmployeeCategory(Integer id) {
		meetingEmployeeCategoryRepository.deleteById(id);
		return " successfully deleted!";
	}
}
