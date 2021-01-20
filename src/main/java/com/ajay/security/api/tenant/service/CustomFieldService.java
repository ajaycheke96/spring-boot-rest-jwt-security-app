package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CustomField;
import com.ajay.security.api.tenant.repository.CustomFieldRepository;

@Service
public class CustomFieldService {

	@Autowired
	private CustomFieldRepository customFieldRepository;

	public List<CustomField> getAllCustomFields() {
		return customFieldRepository.findAll();
	}

	public CustomField getOneCustomField(Integer id) {
		return customFieldRepository.findById(id).get();
	}

	public String saveCustomField(CustomField customField) {
		return customFieldRepository.save(customField) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateCustomField(CustomField customField) {
		return customFieldRepository.save(customField) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCustomField(Integer id) {
		customFieldRepository.deleteById(id);
		return " successfully deleted!";
	}
}
