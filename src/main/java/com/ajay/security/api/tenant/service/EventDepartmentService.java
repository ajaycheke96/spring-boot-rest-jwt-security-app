package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EventDepartment;
import com.ajay.security.api.tenant.repository.EventDepartmentRepository;

@Service
@Transactional
public class EventDepartmentService {

	@Autowired
	private EventDepartmentRepository eventDepartmentRepository;

	public List<EventDepartment> getAllEventDepartments() {
		return eventDepartmentRepository.findAll();
	}

	public EventDepartment getOneEventDepartment(Integer id) {
		return eventDepartmentRepository.findById(id).get();
	}

	public String saveEventDepartment(EventDepartment eventDepartment) {
		return eventDepartmentRepository.save(eventDepartment) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEventDepartment(EventDepartment eventDepartment) {
		return eventDepartmentRepository.save(eventDepartment) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEventDepartment(Integer id) {
		eventDepartmentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
