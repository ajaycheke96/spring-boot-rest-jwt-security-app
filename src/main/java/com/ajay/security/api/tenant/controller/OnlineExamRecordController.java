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

import com.ajay.security.api.tenant.entity.OnlineExamRecord;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.OnlineExamRecordService;

@RestController
@RequestMapping("/onlineExamRecord")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OnlineExamRecordController {

	@Autowired
	private OnlineExamRecordService onlineExamRecordService;

	@GetMapping("/listAllOnlineExamRecord")
	public ApiResponse getAllOnlineExamRecord() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of OnlineExamRecord",
					onlineExamRecordService.getAllOnlineExamRecords());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneOnlineExamRecord(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "OnlineExamRecord",
					onlineExamRecordService.getOneOnlineExamRecord(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveOnlineExamRecord")
	public ApiResponse saveOnlineExamRecord(@RequestBody OnlineExamRecord onlineExamRecord) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "OnlineExamRecord saved!",
					onlineExamRecordService.saveOnlineExamRecord(onlineExamRecord));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateOnlineExamRecord")
	public ApiResponse updateOnlineExamRecord(@RequestBody OnlineExamRecord onlineExamRecord) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "OnlineExamRecord updated!",
					onlineExamRecordService.saveOnlineExamRecord(onlineExamRecord));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteOnlineExamRecord")
	public ApiResponse deleteOneOnlineExamRecord(@RequestBody OnlineExamRecord onlineExamRecord) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					onlineExamRecordService.deleteOneOnlineExamRecord(onlineExamRecord), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"OnlineExamRecord Service exception : " + e.getLocalizedMessage());
		}
	}
}
