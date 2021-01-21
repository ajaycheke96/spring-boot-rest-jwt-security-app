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

import com.ajay.security.api.tenant.entity.StudentRecord;
import com.ajay.security.api.tenant.service.StudentRecordService;

@RestController
@RequestMapping("/studentRecord")
public class StudentRecordController {

	@Autowired
	private StudentRecordService studentRecordService;

	@GetMapping("/all")
	public List<StudentRecord> getAllStudentRecord() {
		return studentRecordService.getAllStudentRecords();
	}

	@GetMapping("/one/{id}")
	public StudentRecord getOneStudentRecord(@PathVariable Integer id) {
		return studentRecordService.getOneStudentRecord(id);
	}

	@PostMapping("/save")
	public String saveStudentRecord(@RequestBody StudentRecord studentRecord) {
		return studentRecordService.saveStudentRecord(studentRecord);
	}

	@PutMapping("/update")
	public String updateStudentRecord(@RequestBody StudentRecord studentRecord) {
		return studentRecordService.updateStudentRecord(studentRecord);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentRecord(@PathVariable Integer id) {
		return studentRecordService.deleteOneStudentRecord(id);
	}
}
