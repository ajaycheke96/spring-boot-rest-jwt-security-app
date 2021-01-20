package com.ajay.security.api.tenant.service;

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

	public String saveCommunication(Communication communication) {
		return communicationRepository.save(communication) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateCommunication(Communication communication) {
		return communicationRepository.save(communication) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCommunication(Integer id) {
		communicationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
