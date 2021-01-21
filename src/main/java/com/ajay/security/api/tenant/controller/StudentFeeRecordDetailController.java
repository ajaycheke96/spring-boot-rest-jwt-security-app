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

import com.ajay.security.api.tenant.entity.StudentFeeRecordDetail;
import com.ajay.security.api.tenant.service.StudentFeeRecordDetailService;

@RestController
@RequestMapping("/studentFeeRecordDetail")
public class StudentFeeRecordDetailController {

	@Autowired
	private StudentFeeRecordDetailService studentFeeRecordDetailService;

	@GetMapping("/all")
	public List<StudentFeeRecordDetail> getAllStudentFeeRecordDetail() {
		return studentFeeRecordDetailService.getAllStudentFeeRecordDetails();
	}

	@GetMapping("/one/{id}")
	public StudentFeeRecordDetail getOneStudentFeeRecordDetail(@PathVariable Integer id) {
		return studentFeeRecordDetailService.getOneStudentFeeRecordDetail(id);
	}

	@PostMapping("/save")
	public String saveStudentFeeRecordDetail(@RequestBody StudentFeeRecordDetail studentFeeRecordDetail) {
		return studentFeeRecordDetailService.saveStudentFeeRecordDetail(studentFeeRecordDetail);
	}

	@PutMapping("/update")
	public String updateStudentFeeRecordDetail(@RequestBody StudentFeeRecordDetail studentFeeRecordDetail) {
		return studentFeeRecordDetailService.updateStudentFeeRecordDetail(studentFeeRecordDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentFeeRecordDetail(@PathVariable Integer id) {
		return studentFeeRecordDetailService.deleteOneStudentFeeRecordDetail(id);
	}
}
