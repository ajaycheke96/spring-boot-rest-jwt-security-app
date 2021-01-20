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

import com.ajay.security.api.tenant.entity.CustomField;
import com.ajay.security.api.tenant.service.CustomFieldService;

@RestController
@RequestMapping("/customField")
public class CustomFieldController {

	@Autowired
	private CustomFieldService customFieldService;

	@GetMapping("/all")
	public List<CustomField> getAllCustomField() {
		return customFieldService.getAllCustomFields();
	}

	@GetMapping("/one/{id}")
	public CustomField getOneCustomField(@PathVariable Integer id) {
		return customFieldService.getOneCustomField(id);
	}

	@PostMapping("/save")
	public String saveCustomField(@RequestBody CustomField customField) {
		return customFieldService.saveCustomField(customField);
	}

	@PutMapping("/update")
	public String updateCustomField(@RequestBody CustomField customField) {
		return customFieldService.updateCustomField(customField);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCustomField(@PathVariable Integer id) {
		return customFieldService.deleteOneCustomField(id);
	}
}
