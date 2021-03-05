package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Communication;
import com.ajay.security.api.tenant.repository.CommunicationRepository;

@Service
public class CommunicationService {

	@Autowired
	private CommunicationRepository communicationRepository;

	public List<Communication> getAllCommunications() {
		return communicationRepository.findAll();
	}

	public Communication getOneCommunication(Integer id) {
		return communicationRepository.findById(id).get();
	}

	public Communication saveCommunication(Communication communication) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (communication.getCreatedAt() == null)
			communication.setCreatedAt(currentTimestamp);
		communication.setUpdatedAt(currentTimestamp);

		// For CommunicationBatches list
		if (!communication.getCommunicationBatches().isEmpty())
			communication.getCommunicationBatches().forEach(communicationBatch -> {
				if (communicationBatch.getCreatedAt() == null)
					communicationBatch.setCreatedAt(currentTimestamp);
				communicationBatch.setUpdatedAt(currentTimestamp);
			});

		// For CommunicationCourses list
		if (!communication.getCommunicationCourses().isEmpty())
			communication.getCommunicationCourses().forEach(communicationCourse -> {
				if (communicationCourse.getCreatedAt() == null)
					communicationCourse.setCreatedAt(currentTimestamp);
				communicationCourse.setUpdatedAt(currentTimestamp);
			});

		// For CommunicationDepartments list
		if (!communication.getCommunicationDepartments().isEmpty())
			communication.getCommunicationDepartments().forEach(communicationDepartment -> {
				if (communicationDepartment.getCreatedAt() == null)
					communicationDepartment.setCreatedAt(currentTimestamp);
				communicationDepartment.setUpdatedAt(currentTimestamp);
			});

		// For Communications list
		if (!communication.getCommunicationEmployeeCategories().isEmpty())
			communication.getCommunicationEmployeeCategories().forEach(communicationEmployeeCategory -> {
				if (communicationEmployeeCategory.getCreatedAt() == null)
					communicationEmployeeCategory.setCreatedAt(currentTimestamp);
				communicationEmployeeCategory.setUpdatedAt(currentTimestamp);
			});

		// For CommunicationEmployees list
		if (!communication.getCommunicationEmployees().isEmpty())
			communication.getCommunicationEmployees().forEach(communicationEmployee -> {
				if (communicationEmployee.getCreatedAt() == null)
					communicationEmployee.setCreatedAt(currentTimestamp);
				communicationEmployee.setUpdatedAt(currentTimestamp);
			});

		// For CommunicationStudentRecords list
		if (!communication.getCommunicationStudentRecords().isEmpty())
			communication.getCommunicationStudentRecords().forEach(communicationStudentRecord -> {
				if (communicationStudentRecord.getCreatedAt() == null)
					communicationStudentRecord.setCreatedAt(currentTimestamp);
				communicationStudentRecord.setUpdatedAt(currentTimestamp);
			});

		return communicationRepository.save(communication);
	}

	public String deleteOneCommunication(Communication communication) {
		communicationRepository.delete(communication);
		return " successfully deleted!";
	}
}
