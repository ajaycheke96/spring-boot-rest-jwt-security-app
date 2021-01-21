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

import com.ajay.security.api.tenant.entity.StudentFeeRecord;
import com.ajay.security.api.tenant.service.StudentFeeRecordService;

@RestController
@RequestMapping("/studentFeeRecord")
public class StudentFeeRecordController {

	@Autowired
	private StudentFeeRecordService studentFeeRecordService;

	@GetMapping("/all")
	public List<StudentFeeRecord> getAllStudentFeeRecord() {
		return studentFeeRecordService.getAllStudentFeeRecords();
	}

	@GetMapping("/one/{id}")
	public StudentFeeRecord getOneStudentFeeRecord(@PathVariable Integer id) {
		return studentFeeRecordService.getOneStudentFeeRecord(id);
	}

	@PostMapping("/save")
	public String saveStudentFeeRecord(@RequestBody StudentFeeRecord studentFeeRecord) {
		return studentFeeRecordService.saveStudentFeeRecord(studentFeeRecord);
	}

	@PutMapping("/update")
	public String updateStudentFeeRecord(@RequestBody StudentFeeRecord studentFeeRecord) {
		return studentFeeRecordService.updateStudentFeeRecord(studentFeeRecord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentFeeRecord(@PathVariable Integer id) {
		return studentFeeRecordService.deleteOneStudentFeeRecord(id);
	}
}
