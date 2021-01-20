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

import com.ajay.security.api.tenant.entity.OnlineExamRecord;
import com.ajay.security.api.tenant.service.OnlineExamRecordService;

@RestController
@RequestMapping("/onlineExamRecord")
public class OnlineExamRecordController {

	@Autowired
	private OnlineExamRecordService onlineExamRecordService;

	@GetMapping("/all")
	public List<OnlineExamRecord> getAllOnlineExamRecord() {
		return onlineExamRecordService.getAllOnlineExamRecords();
	}

	@GetMapping("/one/{id}")
	public OnlineExamRecord getOneOnlineExamRecord(@PathVariable Integer id) {
		return onlineExamRecordService.getOneOnlineExamRecord(id);
	}

	@PostMapping("/save")
	public String saveOnlineExamRecord(@RequestBody OnlineExamRecord onlineExamRecord) {
		return onlineExamRecordService.saveOnlineExamRecord(onlineExamRecord);
	}

	@PutMapping("/update")
	public String updateOnlineExamRecord(@RequestBody OnlineExamRecord onlineExamRecord) {
		return onlineExamRecordService.updateOnlineExamRecord(onlineExamRecord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneOnlineExamRecord(@PathVariable Integer id) {
		return onlineExamRecordService.deleteOneOnlineExamRecord(id);
	}
}
