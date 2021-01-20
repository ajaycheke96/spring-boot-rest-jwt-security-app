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

import com.ajay.security.api.tenant.entity.MeetingBatch;
import com.ajay.security.api.tenant.service.MeetingBatchService;

@RestController
@RequestMapping("/meetingBatch")
public class MeetingBatchController {

	@Autowired
	private MeetingBatchService meetingBatchService;

	@GetMapping("/all")
	public List<MeetingBatch> getAllMeetingBatch() {
		return meetingBatchService.getAllMeetingBatchs();
	}

	@GetMapping("/one/{id}")
	public MeetingBatch getOneMeetingBatch(@PathVariable Integer id) {
		return meetingBatchService.getOneMeetingBatch(id);
	}

	@PostMapping("/save")
	public String saveMeetingBatch(@RequestBody MeetingBatch meetingBatch) {
		return meetingBatchService.saveMeetingBatch(meetingBatch);
	}

	@PutMapping("/update")
	public String updateMeetingBatch(@RequestBody MeetingBatch meetingBatch) {
		return meetingBatchService.updateMeetingBatch(meetingBatch);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneMeetingBatch(@PathVariable Integer id) {
		return meetingBatchService.deleteOneMeetingBatch(id);
	}
}
