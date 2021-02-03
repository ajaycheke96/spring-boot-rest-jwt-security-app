package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VisitorMessage;
import com.ajay.security.api.tenant.repository.VisitorMessageRepository;

@Service
@Transactional
public class VisitorMessageService {

	@Autowired
	private VisitorMessageRepository visitorMessageRepository;

	public List<VisitorMessage> getAllVisitorMessages() {
		return visitorMessageRepository.findAll();
	}

	public VisitorMessage getOneVisitorMessage(Integer id) {
		return visitorMessageRepository.findById(id).get();
	}

	public String saveVisitorMessage(VisitorMessage visitorMessage) {
		Timestamp curTimestamp = new Timestamp(System.currentTimeMillis());
		visitorMessage.setCreatedAt(curTimestamp);
		visitorMessage.setUpdatedAt(curTimestamp);

		return visitorMessageRepository.save(visitorMessage) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVisitorMessage(VisitorMessage visitorMessage) {
		Timestamp curTimestamp = new Timestamp(System.currentTimeMillis());
		visitorMessage.setUpdatedAt(curTimestamp);
		return visitorMessageRepository.save(visitorMessage) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVisitorMessage(Integer id) {
		visitorMessageRepository.deleteById(id);
		return " successfully deleted!";
	}
}
