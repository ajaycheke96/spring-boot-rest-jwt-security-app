package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.EmailTemplate;
import com.ajay.security.api.tenant.service.EmailTemplateService;

@RestController
@RequestMapping("/emailTemplate")
public class EmailTemplateController {

	@Autowired
	private EmailTemplateService emailTemplateService;

	@GetMapping("/all")
	public List<EmailTemplate> getAllEmailTemplate() {
		return emailTemplateService.getAllEmailTemplates();
	}

	@GetMapping("/one/{id}")
	public EmailTemplate getOneEmailTemplate(@PathVariable Integer id) {
		return emailTemplateService.getOneEmailTemplate(id);
	}

	@PostMapping("/save")
	public String saveEmailTemplate(@RequestBody EmailTemplate emailTemplate) {
		return emailTemplateService.saveEmailTemplate(emailTemplate);
	}

	@PutMapping("/update")
	public String updateEmailTemplate(@RequestBody EmailTemplate emailTemplate) {
		return emailTemplateService.updateEmailTemplate(emailTemplate);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmailTemplate(@PathVariable Integer id) {
		return emailTemplateService.deleteOneEmailTemplate(id);
	}
}
