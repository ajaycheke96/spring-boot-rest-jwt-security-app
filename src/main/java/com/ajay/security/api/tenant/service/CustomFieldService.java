package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public CustomField saveCustomField(CustomField customField) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (customField.getCreatedAt() == null)
			customField.setCreatedAt(currentTimestamp);
		customField.setUpdatedAt(currentTimestamp);
		return customFieldRepository.save(customField);
	}

	public String deleteOneCustomField(CustomField customField) {
		String result = null;
		if (customFieldRepository.existsById(customField.getId())) {
			customFieldRepository.delete(customField);
			result = " CustomField deleted!";
		} else {
			result = "CustomField Not Found! or Already deleted!";
		}
		return result;
	}
}
