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

import com.ajay.security.api.tenant.entity.CallingPurpos;
import com.ajay.security.api.tenant.service.CallingPurposService;

@RestController
@RequestMapping("/callingPurpos")
public class CallingPurposController {

	@Autowired
	private CallingPurposService callingPurposService;

	@GetMapping("/all")
	public List<CallingPurpos> getAllCallingPurpos() {
		return callingPurposService.getAllCallingPurposs();
	}

	@GetMapping("/one/{id}")
	public CallingPurpos getOneCallingPurpos(@PathVariable Integer id) {
		return callingPurposService.getOneCallingPurpos(id);
	}

	@PostMapping("/save")
	public String saveCallingPurpos(@RequestBody CallingPurpos callingPurpos) {
		return callingPurposService.saveCallingPurpos(callingPurpos);
	}

	@PutMapping("/update")
	public String updateCallingPurpos(@RequestBody CallingPurpos callingPurpos) {
		return callingPurposService.updateCallingPurpos(callingPurpos);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCallingPurpos(@PathVariable Integer id) {
		return callingPurposService.deleteOneCallingPurpos(id);
	}
}
