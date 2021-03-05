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

import com.ajay.security.api.tenant.entity.IdCardTemplate;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.IdCardTemplateService;

@RestController
@RequestMapping("/idCardTemplate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class IdCardTemplateController {

	@Autowired
	private IdCardTemplateService idCardTemplateService;

	@GetMapping("/listAllIdCardTemplate")
	public ApiResponse getAllIdCardTemplate() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of IdCardTemplate",
					idCardTemplateService.getAllIdCardTemplates());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IdCardTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneIdCardTemplate(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "IdCardTemplate",
					idCardTemplateService.getOneIdCardTemplate(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IdCardTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveIdCardTemplate")
	public ApiResponse saveIdCardTemplate(@RequestBody IdCardTemplate idCardTemplate) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "IdCardTemplate saved!",
					idCardTemplateService.saveIdCardTemplate(idCardTemplate));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IdCardTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateIdCardTemplate")
	public ApiResponse updateIdCardTemplate(@RequestBody IdCardTemplate idCardTemplate) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "IdCardTemplate updated!",
					idCardTemplateService.saveIdCardTemplate(idCardTemplate));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IdCardTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteIdCardTemplate")
	public ApiResponse deleteOneIdCardTemplate(@RequestBody IdCardTemplate idCardTemplate) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					idCardTemplateService.deleteOneIdCardTemplate(idCardTemplate), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IdCardTemplate Service exception : " + e.getLocalizedMessage());
		}
	}
}
