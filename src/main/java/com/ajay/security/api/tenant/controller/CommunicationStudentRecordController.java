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

import com.ajay.security.api.tenant.entity.CommunicationStudentRecord;
import com.ajay.security.api.tenant.service.CommunicationStudentRecordService;

@RestController
@RequestMapping("/communicationStudentRecord")
public class CommunicationStudentRecordController {

	@Autowired
	private CommunicationStudentRecordService communicationStudentRecordService;

	@GetMapping("/all")
	public List<CommunicationStudentRecord> getAllCommunicationStudentRecord() {
		return communicationStudentRecordService.getAllCommunicationStudentRecords();
	}

	@GetMapping("/one/{id}")
	public CommunicationStudentRecord getOneCommunicationStudentRecord(@PathVariable Integer id) {
		return communicationStudentRecordService.getOneCommunicationStudentRecord(id);
	}

	@PostMapping("/save")
	public String saveCommunicationStudentRecord(@RequestBody CommunicationStudentRecord communicationStudentRecord) {
		return communicationStudentRecordService.saveCommunicationStudentRecord(communicationStudentRecord);
	}

	@PutMapping("/update")
	public String updateCommunicationStudentRecord(@RequestBody CommunicationStudentRecord communicationStudentRecord) {
		return communicationStudentRecordService.updateCommunicationStudentRecord(communicationStudentRecord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCommunicationStudentRecord(@PathVariable Integer id) {
		return communicationStudentRecordService.deleteOneCommunicationStudentRecord(id);
	}
}
