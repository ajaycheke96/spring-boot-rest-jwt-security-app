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

	public VisitorMessage saveVisitorMessage(VisitorMessage visitorMessage) {
		Timestamp curTimestamp = new Timestamp(System.currentTimeMillis());
		if (visitorMessage.getCreatedAt() == null)
			visitorMessage.setCreatedAt(curTimestamp);
		visitorMessage.setUpdatedAt(curTimestamp);
		return visitorMessageRepository.save(visitorMessage);
	}

	public String deleteOneVisitorMessage(VisitorMessage visitorMessage) {
		String result = null;
		if (visitorMessageRepository.existsById(visitorMessage.getId())) {
			visitorMessageRepository.delete(visitorMessage);
			result = " VisitorMessage deleted!";
		} else {
			result = "VisitorMessage Not Found! or Already deleted!";
		}
		return result;
	}
}
