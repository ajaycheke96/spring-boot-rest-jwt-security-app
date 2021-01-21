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

import com.ajay.security.api.tenant.entity.StudentOptionalFeeRecord;
import com.ajay.security.api.tenant.service.StudentOptionalFeeRecordService;

@RestController
@RequestMapping("/studentOptionalFeeRecord")
public class StudentOptionalFeeRecordController {

	@Autowired
	private StudentOptionalFeeRecordService studentOptionalFeeRecordService;

	@GetMapping("/all")
	public List<StudentOptionalFeeRecord> getAllStudentOptionalFeeRecord() {
		return studentOptionalFeeRecordService.getAllStudentOptionalFeeRecords();
	}

	@GetMapping("/one/{id}")
	public StudentOptionalFeeRecord getOneStudentOptionalFeeRecord(@PathVariable Integer id) {
		return studentOptionalFeeRecordService.getOneStudentOptionalFeeRecord(id);
	}

	@PostMapping("/save")
	public String saveStudentOptionalFeeRecord(@RequestBody StudentOptionalFeeRecord studentOptionalFeeRecord) {
		return studentOptionalFeeRecordService.saveStudentOptionalFeeRecord(studentOptionalFeeRecord);
	}

	@PutMapping("/update")
	public String updateStudentOptionalFeeRecord(@RequestBody StudentOptionalFeeRecord studentOptionalFeeRecord) {
		return studentOptionalFeeRecordService.updateStudentOptionalFeeRecord(studentOptionalFeeRecord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentOptionalFeeRecord(@PathVariable Integer id) {
		return studentOptionalFeeRecordService.deleteOneStudentOptionalFeeRecord(id);
	}
}
