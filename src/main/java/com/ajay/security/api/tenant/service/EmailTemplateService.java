package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmailTemplate;
import com.ajay.security.api.tenant.repository.EmailTemplateRepository;

@Service
@Transactional
public class EmailTemplateService {

	@Autowired
	private EmailTemplateRepository emailTemplateRepository;

	public List<EmailTemplate> getAllEmailTemplates() {
		return emailTemplateRepository.findAll();
	}

	public EmailTemplate getOneEmailTemplate(Integer id) {
		return emailTemplateRepository.findById(id).get();
	}

	public EmailTemplate saveEmailTemplate(EmailTemplate emailTemplate) {
		Timestamp curTimestamp = new Timestamp(System.currentTimeMillis());
		if (emailTemplate.getCreatedAt() == null)
			emailTemplate.setCreatedAt(curTimestamp);
		emailTemplate.setUpdatedAt(curTimestamp);
		return emailTemplateRepository.save(emailTemplate);
	}

	public String deleteOneEmailTemplate(EmailTemplate emailTemplate) {
		String result = null;
		if (emailTemplateRepository.existsById(emailTemplate.getId())) {
			emailTemplateRepository.delete(emailTemplate);
			result = " EmailTemplate deleted!";
		} else {
			result = "EmailTemplate Not Found! or Already deleted!";
		}
		return result;
	}
}
