package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CommunicationBatch;
import com.ajay.security.api.tenant.repository.CommunicationBatchRepository;

@Service
public class CommunicationBatchService {

	@Autowired
	private CommunicationBatchRepository communicationBatchRepository;

	public List<CommunicationBatch> getAllCommunicationBatchs() {
		return communicationBatchRepository.findAll();
	}

	public CommunicationBatch getOneCommunicationBatch(Integer id) {
		return communicationBatchRepository.findById(id).get();
	}

	public String saveCommunicationBatch(CommunicationBatch communicationBatch) {
		return communicationBatchRepository.save(communicationBatch) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateCommunicationBatch(CommunicationBatch communicationBatch) {
		return communicationBatchRepository.save(communicationBatch) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCommunicationBatch(Integer id) {
		communicationBatchRepository.deleteById(id);
		return " successfully deleted!";
	}
}
