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

import com.ajay.security.api.tenant.entity.Communication;
import com.ajay.security.api.tenant.service.CommunicationService;

@RestController
@RequestMapping("/communication")
public class CommunicationController {

	@Autowired
	private CommunicationService communicationService;

	@GetMapping("/all")
	public List<Communication> getAllCommunication() {
		return communicationService.getAllCommunications();
	}

	@GetMapping("/one/{id}")
	public Communication getOneCommunication(@PathVariable Integer id) {
		return communicationService.getOneCommunication(id);
	}

	@PostMapping("/save")
	public String saveCommunication(@RequestBody Communication communication) {
		return communicationService.saveCommunication(communication);
	}

	@PutMapping("/update")
	public String updateCommunication(@RequestBody Communication communication) {
		return communicationService.updateCommunication(communication);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCommunication(@PathVariable Integer id) {
		return communicationService.deleteOneCommunication(id);
	}
}
