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

import com.ajay.security.api.tenant.entity.Batch;
import com.ajay.security.api.tenant.service.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {

	@Autowired
	private BatchService batchService;

	@GetMapping("/all")
	public List<Batch> getAllBatch() {
		return batchService.getAllBatchs();
	}

	@GetMapping("/one/{id}")
	public Batch getOneBatch(@PathVariable Integer id) {
		return batchService.getOneBatch(id);
	}

	@PostMapping("/save")
	public String saveBatch(@RequestBody Batch batch) {
		return batchService.saveBatch(batch);
	}

	@PutMapping("/update")
	public String updateBatch(@RequestBody Batch batch) {
		return batchService.updateBatch(batch);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBatch(@PathVariable Integer id) {
		return batchService.deleteOneBatch(id);
	}
}
