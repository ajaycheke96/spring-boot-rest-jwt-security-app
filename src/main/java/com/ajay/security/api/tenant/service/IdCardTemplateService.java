package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.IdCardTemplate;
import com.ajay.security.api.tenant.repository.IdCardTemplateRepository;

@Service
@Transactional
public class IdCardTemplateService {

	@Autowired
	private IdCardTemplateRepository idCardTemplateRepository;

	public List<IdCardTemplate> getAllIdCardTemplates() {
		return idCardTemplateRepository.findAll();
	}

	public IdCardTemplate getOneIdCardTemplate(Integer id) {
		return idCardTemplateRepository.findById(id).get();
	}

	public String saveIdCardTemplate(IdCardTemplate idCardTemplate) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		idCardTemplate.setCreatedAt(currentTimestamp);
		idCardTemplate.setUpdatedAt(currentTimestamp);

		return idCardTemplateRepository.save(idCardTemplate) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateIdCardTemplate(IdCardTemplate idCardTemplate) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		idCardTemplate.setUpdatedAt(currentTimestamp);

		return idCardTemplateRepository.save(idCardTemplate) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneIdCardTemplate(Integer id) {
		idCardTemplateRepository.deleteById(id);
		return " successfully deleted!";
	}
}
