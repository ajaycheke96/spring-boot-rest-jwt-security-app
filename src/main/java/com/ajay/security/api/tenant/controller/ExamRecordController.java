package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.ExamRecord;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ExamRecordService;

@RestController
@RequestMapping("/examRecord")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExamRecordController {

	@Autowired
	private ExamRecordService examRecordService;

	@GetMapping("/listAllExamRecord")
	public ApiResponse getAllExamRecord() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ExamRecord",
					examRecordService.getAllExamRecords());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneExamRecord(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamRecord",
					examRecordService.getOneExamRecord(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveExamRecord")
	public ApiResponse saveExamRecord(@RequestBody ExamRecord examRecord) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamRecord saved!",
					examRecordService.saveExamRecord(examRecord));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateExamRecord")
	public ApiResponse updateExamRecord(@RequestBody ExamRecord examRecord) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ExamRecord updated!",
					examRecordService.saveExamRecord(examRecord));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteExamRecord")
	public ApiResponse deleteOneExamRecord(@RequestBody ExamRecord examRecord) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, examRecordService.deleteOneExamRecord(examRecord),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}
}
