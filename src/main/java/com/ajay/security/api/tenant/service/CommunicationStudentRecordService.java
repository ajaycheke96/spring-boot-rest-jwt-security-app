package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CommunicationStudentRecord;
import com.ajay.security.api.tenant.repository.CommunicationStudentRecordRepository;

@Service
public class CommunicationStudentRecordService {

	@Autowired
	private CommunicationStudentRecordRepository communicationStudentRecordRepository;

	public List<CommunicationStudentRecord> getAllCommunicationStudentRecords() {
		return communicationStudentRecordRepository.findAll();
	}

	public CommunicationStudentRecord getOneCommunicationStudentRecord(Integer id) {
		return communicationStudentRecordRepository.findById(id).get();
	}

	public String saveCommunicationStudentRecord(CommunicationStudentRecord communicationStudentRecord) {
		return communicationStudentRecordRepository.save(communicationStudentRecord) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateCommunicationStudentRecord(CommunicationStudentRecord communicationStudentRecord) {
		return communicationStudentRecordRepository.save(communicationStudentRecord) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCommunicationStudentRecord(Integer id) {
		communicationStudentRecordRepository.deleteById(id);
		return " successfully deleted!";
	}
}
