package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.MeetingBatch;
import com.ajay.security.api.tenant.repository.MeetingBatchRepository;

@Service
@Transactional
public class MeetingBatchService {

	@Autowired
	private MeetingBatchRepository meetingBatchRepository;

	public List<MeetingBatch> getAllMeetingBatchs() {
		return meetingBatchRepository.findAll();
	}

	public MeetingBatch getOneMeetingBatch(Integer id) {
		return meetingBatchRepository.findById(id).get();
	}

	public String saveMeetingBatch(MeetingBatch meetingBatch) {
		return meetingBatchRepository.save(meetingBatch) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateMeetingBatch(MeetingBatch meetingBatch) {
		return meetingBatchRepository.save(meetingBatch) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneMeetingBatch(Integer id) {
		meetingBatchRepository.deleteById(id);
		return " successfully deleted!";
	}
}
