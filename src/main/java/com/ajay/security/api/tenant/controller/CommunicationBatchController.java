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

import com.ajay.security.api.tenant.entity.CommunicationBatch;
import com.ajay.security.api.tenant.service.CommunicationBatchService;

@RestController
@RequestMapping("/communicationBatch")
public class CommunicationBatchController {

	@Autowired
	private CommunicationBatchService communicationBatchService;

	@GetMapping("/all")
	public List<CommunicationBatch> getAllCommunicationBatch() {
		return communicationBatchService.getAllCommunicationBatchs();
	}

	@GetMapping("/one/{id}")
	public CommunicationBatch getOneCommunicationBatch(@PathVariable Integer id) {
		return communicationBatchService.getOneCommunicationBatch(id);
	}

	@PostMapping("/save")
	public String saveCommunicationBatch(@RequestBody CommunicationBatch communicationBatch) {
		return communicationBatchService.saveCommunicationBatch(communicationBatch);
	}

	@PutMapping("/update")
	public String updateCommunicationBatch(@RequestBody CommunicationBatch communicationBatch) {
		return communicationBatchService.updateCommunicationBatch(communicationBatch);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCommunicationBatch(@PathVariable Integer id) {
		return communicationBatchService.deleteOneCommunicationBatch(id);
	}
}
