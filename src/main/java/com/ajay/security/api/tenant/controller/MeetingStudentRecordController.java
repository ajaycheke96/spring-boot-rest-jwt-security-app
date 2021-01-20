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

import com.ajay.security.api.tenant.entity.MeetingStudentRecord;
import com.ajay.security.api.tenant.service.MeetingStudentRecordService;

@RestController
@RequestMapping("/meetingStudentRecord")
public class MeetingStudentRecordController {

	@Autowired
	private MeetingStudentRecordService meetingStudentRecordService;

	@GetMapping("/all")
	public List<MeetingStudentRecord> getAllMeetingStudentRecord() {
		return meetingStudentRecordService.getAllMeetingStudentRecords();
	}

	@GetMapping("/one/{id}")
	public MeetingStudentRecord getOneMeetingStudentRecord(@PathVariable Integer id) {
		return meetingStudentRecordService.getOneMeetingStudentRecord(id);
	}

	@PostMapping("/save")
	public String saveMeetingStudentRecord(@RequestBody MeetingStudentRecord meetingStudentRecord) {
		return meetingStudentRecordService.saveMeetingStudentRecord(meetingStudentRecord);
	}

	@PutMapping("/update")
	public String updateMeetingStudentRecord(@RequestBody MeetingStudentRecord meetingStudentRecord) {
		return meetingStudentRecordService.updateMeetingStudentRecord(meetingStudentRecord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneMeetingStudentRecord(@PathVariable Integer id) {
		return meetingStudentRecordService.deleteOneMeetingStudentRecord(id);
	}
}
