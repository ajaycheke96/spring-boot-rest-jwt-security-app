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

import com.ajay.security.api.tenant.entity.IdCardTemplate;
import com.ajay.security.api.tenant.service.IdCardTemplateService;

@RestController
@RequestMapping("/idCardTemplate")
public class IdCardTemplateController {

	@Autowired
	private IdCardTemplateService idCardTemplateService;

	@GetMapping("/all")
	public List<IdCardTemplate> getAllIdCardTemplate() {
		return idCardTemplateService.getAllIdCardTemplates();
	}

	@GetMapping("/one/{id}")
	public IdCardTemplate getOneIdCardTemplate(@PathVariable Integer id) {
		return idCardTemplateService.getOneIdCardTemplate(id);
	}

	@PostMapping("/save")
	public String saveIdCardTemplate(@RequestBody IdCardTemplate idCardTemplate) {
		return idCardTemplateService.saveIdCardTemplate(idCardTemplate);
	}

	@PutMapping("/update")
	public String updateIdCardTemplate(@RequestBody IdCardTemplate idCardTemplate) {
		return idCardTemplateService.updateIdCardTemplate(idCardTemplate);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneIdCardTemplate(@PathVariable Integer id) {
		return idCardTemplateService.deleteOneIdCardTemplate(id);
	}
}
