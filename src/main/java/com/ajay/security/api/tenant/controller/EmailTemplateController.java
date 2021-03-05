package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.EmailTemplate;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmailTemplateService;

@RestController
@RequestMapping("/emailTemplate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmailTemplateController {

	@Autowired
	private EmailTemplateService emailTemplateService;

	@GetMapping("/listAllEmailTemplate")
	public ApiResponse getAllEmailTemplate() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmailTemplate",
					emailTemplateService.getAllEmailTemplates());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmailTemplate(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmailTemplate",
					emailTemplateService.getOneEmailTemplate(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmailTemplate")
	public ApiResponse saveEmailTemplate(@RequestBody EmailTemplate emailTemplate) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmailTemplate saved!",
					emailTemplateService.saveEmailTemplate(emailTemplate));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmailTemplate")
	public ApiResponse updateEmailTemplate(@RequestBody EmailTemplate emailTemplate) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmailTemplate updated!",
					emailTemplateService.saveEmailTemplate(emailTemplate));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmailTemplate")
	public ApiResponse deleteOneEmailTemplate(@RequestBody EmailTemplate emailTemplate) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					emailTemplateService.deleteOneEmailTemplate(emailTemplate), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmailTemplate Service exception : " + e.getLocalizedMessage());
		}
	}
}
