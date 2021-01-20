package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EventEmployeeCategory;
import com.ajay.security.api.tenant.repository.EventEmployeeCategoryRepository;

@Service
@Transactional
public class EventEmployeeCategoryService {

	@Autowired
	private EventEmployeeCategoryRepository eventEmployeeCategoryRepository;

	public List<EventEmployeeCategory> getAllEventEmployeeCategorys() {
		return eventEmployeeCategoryRepository.findAll();
	}

	public EventEmployeeCategory getOneEventEmployeeCategory(Integer id) {
		return eventEmployeeCategoryRepository.findById(id).get();
	}

	public String saveEventEmployeeCategory(EventEmployeeCategory eventEmployeeCategory) {
		return eventEmployeeCategoryRepository.save(eventEmployeeCategory) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEventEmployeeCategory(EventEmployeeCategory eventEmployeeCategory) {
		return eventEmployeeCategoryRepository.save(eventEmployeeCategory) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEventEmployeeCategory(Integer id) {
		eventEmployeeCategoryRepository.deleteById(id);
		return " successfully deleted!";
	}
}
