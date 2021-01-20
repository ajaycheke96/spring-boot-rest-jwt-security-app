package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeGroupCollection;
import com.ajay.security.api.tenant.repository.EmployeeGroupCollectionRepository;

@Service
@Transactional
public class EmployeeGroupCollectionService {

	@Autowired
	private EmployeeGroupCollectionRepository employeeGroupCollectionRepository;

	public List<EmployeeGroupCollection> getAllEmployeeGroupCollections() {
		return employeeGroupCollectionRepository.findAll();
	}

	public EmployeeGroupCollection getOneEmployeeGroupCollection(Integer id) {
		return employeeGroupCollectionRepository.findById(id).get();
	}

	public String saveEmployeeGroupCollection(EmployeeGroupCollection employeeGroupCollection) {
		return employeeGroupCollectionRepository.save(employeeGroupCollection) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeGroupCollection(EmployeeGroupCollection employeeGroupCollection) {
		return employeeGroupCollectionRepository.save(employeeGroupCollection) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeGroupCollection(Integer id) {
		employeeGroupCollectionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
