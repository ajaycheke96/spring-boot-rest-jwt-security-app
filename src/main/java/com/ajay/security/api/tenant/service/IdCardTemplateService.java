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

	public IdCardTemplate saveIdCardTemplate(IdCardTemplate idCardTemplate) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (idCardTemplate.getCreatedAt() == null)
			idCardTemplate.setCreatedAt(currentTimestamp);
		idCardTemplate.setUpdatedAt(currentTimestamp);

		return idCardTemplateRepository.save(idCardTemplate);
	}

	public String deleteOneIdCardTemplate(IdCardTemplate idCardTemplate) {
		String result = null;
		if (idCardTemplateRepository.existsById(idCardTemplate.getId())) {
			idCardTemplateRepository.delete(idCardTemplate);
			result = " IdCardTemplate deleted!";
		} else {
			result = "IdCardTemplate Not Found! or Already deleted!";
		}
		return result;
	}
}
