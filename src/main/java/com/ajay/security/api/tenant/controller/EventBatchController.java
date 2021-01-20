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

import com.ajay.security.api.tenant.entity.EventBatch;
import com.ajay.security.api.tenant.service.EventBatchService;

@RestController
@RequestMapping("/eventBatch")
public class EventBatchController {

	@Autowired
	private EventBatchService eventBatchService;

	@GetMapping("/all")
	public List<EventBatch> getAllEventBatch() {
		return eventBatchService.getAllEventBatchs();
	}

	@GetMapping("/one/{id}")
	public EventBatch getOneEventBatch(@PathVariable Integer id) {
		return eventBatchService.getOneEventBatch(id);
	}

	@PostMapping("/save")
	public String saveEventBatch(@RequestBody EventBatch eventBatch) {
		return eventBatchService.saveEventBatch(eventBatch);
	}

	@PutMapping("/update")
	public String updateEventBatch(@RequestBody EventBatch eventBatch) {
		return eventBatchService.updateEventBatch(eventBatch);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEventBatch(@PathVariable Integer id) {
		return eventBatchService.deleteOneEventBatch(id);
	}
}
