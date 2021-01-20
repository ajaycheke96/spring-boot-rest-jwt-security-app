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

import com.ajay.security.api.tenant.entity.PostalRecord;
import com.ajay.security.api.tenant.service.PostalRecordService;

@RestController
@RequestMapping("/postalRecord")
public class PostalRecordController {

	@Autowired
	private PostalRecordService postalRecordService;

	@GetMapping("/all")
	public List<PostalRecord> getAllPostalRecord() {
		return postalRecordService.getAllPostalRecords();
	}

	@GetMapping("/one/{id}")
	public PostalRecord getOnePostalRecord(@PathVariable Integer id) {
		return postalRecordService.getOnePostalRecord(id);
	}

	@PostMapping("/save")
	public String savePostalRecord(@RequestBody PostalRecord postalRecord) {
		return postalRecordService.savePostalRecord(postalRecord);
	}

	@PutMapping("/update")
	public String updatePostalRecord(@RequestBody PostalRecord postalRecord) {
		return postalRecordService.updatePostalRecord(postalRecord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOnePostalRecord(@PathVariable Integer id) {
		return postalRecordService.deleteOnePostalRecord(id);
	}
}
