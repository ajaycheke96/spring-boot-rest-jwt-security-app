package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Meeting saveMeeting(Meeting meeting) {
		Timestamp cuurentTimestamp = new Timestamp(System.currentTimeMillis());
		if (meeting.getCreatedAt() == null)
			meeting.setCreatedAt(cuurentTimestamp);
		meeting.setUpdatedAt(cuurentTimestamp);

		// For MeetingBatches list
		if (!meeting.getMeetingBatches().isEmpty())
			meeting.getMeetingBatches().forEach(meetingBatch -> {
				if (meetingBatch.getCreatedAt() == null)
					meetingBatch.setCreatedAt(cuurentTimestamp);
				meetingBatch.setUpdatedAt(cuurentTimestamp);
			});

		// For MeetingCourses list
		if (!meeting.getMeetingCourses().isEmpty())
			meeting.getMeetingCourses().forEach(meetingCourse -> {
				if (meetingCourse.getCreatedAt() == null)
					meetingCourse.setCreatedAt(cuurentTimestamp);
				meetingCourse.setUpdatedAt(cuurentTimestamp);
			});

		// For MeetingDepartments list
		if (!meeting.getMeetingDepartments().isEmpty())
			meeting.getMeetingDepartments().forEach(meetingDepartment -> {
				if (meetingDepartment.getCreatedAt() == null)
					meetingDepartment.setCreatedAt(cuurentTimestamp);
				meetingDepartment.setUpdatedAt(cuurentTimestamp);
			});

		// For MeetingEmployeeCategories list
		if (!meeting.getMeetingEmployeeCategories().isEmpty())
			meeting.getMeetingEmployeeCategories().forEach(meetingEmployeeCategory -> {
				if (meetingEmployeeCategory.getCreatedAt() == null)
					meetingEmployeeCategory.setCreatedAt(cuurentTimestamp);
				meetingEmployeeCategory.setUpdatedAt(cuurentTimestamp);
			});

		// For MeetingEmployees list
		if (!meeting.getMeetingEmployees().isEmpty())
			meeting.getMeetingEmployees().forEach(meetingEmployee -> {
				if (meetingEmployee.getCreatedAt() == null)
					meetingEmployee.setCreatedAt(cuurentTimestamp);
				meetingEmployee.setUpdatedAt(cuurentTimestamp);
			});

		// For MeetingStudentRecords list
		if (!meeting.getMeetingStudentRecords().isEmpty())
			meeting.getMeetingStudentRecords().forEach(meetingStudentRecord -> {
				if (meetingStudentRecord.getCreatedAt() == null)
					meetingStudentRecord.setCreatedAt(cuurentTimestamp);
				meetingStudentRecord.setUpdatedAt(cuurentTimestamp);
			});

		return meetingRepository.save(meeting);
	}

	public String deleteOneMeeting(Meeting meeting) {
		String result = null;
		if (meetingRepository.existsById(meeting.getId())) {
			meetingRepository.delete(meeting);
			result = "Meeting deleted!";
		} else {
			result = "Meeting not found! Or Already deleted!";
		}
		return result;
	}
}
