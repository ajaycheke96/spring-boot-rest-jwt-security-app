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

import com.ajay.security.api.tenant.entity.VisitorMessage;
import com.ajay.security.api.tenant.service.VisitorMessageService;

@RestController
@RequestMapping("/visitorMessage")
public class VisitorMessageController {

	@Autowired
	private VisitorMessageService visitorMessageService;

	@GetMapping("/all")
	public List<VisitorMessage> getAllVisitorMessage() {
		return visitorMessageService.getAllVisitorMessages();
	}

	@GetMapping("/one/{id}")
	public VisitorMessage getOneVisitorMessage(@PathVariable Integer id) {
		return visitorMessageService.getOneVisitorMessage(id);
	}

	@PostMapping("/save")
	public String saveVisitorMessage(@RequestBody VisitorMessage visitorMessage) {
		return visitorMessageService.saveVisitorMessage(visitorMessage);
	}

	@PutMapping("/update")
	public String updateVisitorMessage(@RequestBody VisitorMessage visitorMessage) {
		return visitorMessageService.updateVisitorMessage(visitorMessage);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVisitorMessage(@PathVariable Integer id) {
		return visitorMessageService.deleteOneVisitorMessage(id);
	}
}
