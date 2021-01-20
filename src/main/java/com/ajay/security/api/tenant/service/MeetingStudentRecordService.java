package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.MeetingStudentRecord;
import com.ajay.security.api.tenant.repository.MeetingStudentRecordRepository;

@Service
public class MeetingStudentRecordService {

	@Autowired
	private MeetingStudentRecordRepository meetingStudentRecordRepository;

	public List<MeetingStudentRecord> getAllMeetingStudentRecords() {
		return meetingStudentRecordRepository.findAll();
	}

	public MeetingStudentRecord getOneMeetingStudentRecord(Integer id) {
		return meetingStudentRecordRepository.findById(id).get();
	}

	public String saveMeetingStudentRecord(MeetingStudentRecord meetingStudentRecord) {
		return meetingStudentRecordRepository.save(meetingStudentRecord) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateMeetingStudentRecord(MeetingStudentRecord meetingStudentRecord) {
		return meetingStudentRecordRepository.save(meetingStudentRecord) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneMeetingStudentRecord(Integer id) {
		meetingStudentRecordRepository.deleteById(id);
		return " successfully deleted!";
	}
}
