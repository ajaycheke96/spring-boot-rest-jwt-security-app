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

import com.ajay.security.api.tenant.entity.ExamRecord;
import com.ajay.security.api.tenant.service.ExamRecordService;

@RestController
@RequestMapping("/examRecord")
public class ExamRecordController {

	@Autowired
	private ExamRecordService examRecordService;

	@GetMapping("/all")
	public List<ExamRecord> getAllExamRecord() {
		return examRecordService.getAllExamRecords();
	}

	@GetMapping("/one/{id}")
	public ExamRecord getOneExamRecord(@PathVariable Integer id) {
		return examRecordService.getOneExamRecord(id);
	}

	@PostMapping("/save")
	public String saveExamRecord(@RequestBody ExamRecord examRecord) {
		return examRecordService.saveExamRecord(examRecord);
	}

	@PutMapping("/update")
	public String updateExamRecord(@RequestBody ExamRecord examRecord) {
		return examRecordService.updateExamRecord(examRecord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExamRecord(@PathVariable Integer id) {
		return examRecordService.deleteOneExamRecord(id);
	}
}
