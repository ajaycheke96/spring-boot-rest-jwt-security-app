package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Meeting;
import com.ajay.security.api.tenant.repository.MeetingRepository;

@Service
@Transactional
public class MeetingService {

	@Autowired
	private MeetingRepository meetingRepository;

	public List<Meeting> getAllMeetings() {
		return meetingRepository.findAll();
	}

	public Meeting getOneMeeting(Integer id) {
		return meetingRepository.findById(id).get();
	}

	public String saveMeeting(Meeting meeting) {
		return meetingRepository.save(meeting) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateMeeting(Meeting meeting) {
		return meetingRepository.save(meeting) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneMeeting(Integer id) {
		meetingRepository.deleteById(id);
		return " successfully deleted!";
	}
}
