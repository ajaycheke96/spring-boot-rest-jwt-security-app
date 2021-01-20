package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EventBatch;
import com.ajay.security.api.tenant.repository.EventBatchRepository;

@Service
@Transactional
public class EventBatchService {

	@Autowired
	private EventBatchRepository eventBatchRepository;

	public List<EventBatch> getAllEventBatchs() {
		return eventBatchRepository.findAll();
	}

	public EventBatch getOneEventBatch(Integer id) {
		return eventBatchRepository.findById(id).get();
	}

	public String saveEventBatch(EventBatch eventBatch) {
		return eventBatchRepository.save(eventBatch) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEventBatch(EventBatch eventBatch) {
		return eventBatchRepository.save(eventBatch) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneEventBatch(Integer id) {
		eventBatchRepository.deleteById(id);
		return " successfully deleted!";
	}
}
