package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.EmailTemplate;
import com.ajay.security.api.tenant.repository.EmailTemplateRepository;

@Service
public class EmailTemplateService {

	@Autowired
	private EmailTemplateRepository emailTemplateRepository;

	public List<EmailTemplate> getAllEmailTemplates() {
		return emailTemplateRepository.findAll();
	}

	public EmailTemplate getOneEmailTemplate(Integer id) {
		return emailTemplateRepository.findById(id).get();
	}

	public String saveEmailTemplate(EmailTemplate emailTemplate) {
		return emailTemplateRepository.save(emailTemplate) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmailTemplate(EmailTemplate emailTemplate) {
		return emailTemplateRepository.save(emailTemplate) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmailTemplate(Integer id) {
		emailTemplateRepository.deleteById(id);
		return " successfully deleted!";
	}
}
