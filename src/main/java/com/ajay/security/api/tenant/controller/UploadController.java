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

import com.ajay.security.api.tenant.entity.Upload;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.UploadService;

@RestController
@RequestMapping("/upload")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@GetMapping("/listAllUpload")
	public ApiResponse getAllUpload() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Upload", uploadService.getAllUploads());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Upload Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneUpload(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Upload", uploadService.getOneUpload(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Upload Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveUpload")
	public ApiResponse saveUpload(@RequestBody Upload upload) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Upload saved!", uploadService.saveUpload(upload));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Upload Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateUpload")
	public ApiResponse updateUpload(@RequestBody Upload upload) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Upload updated!", uploadService.saveUpload(upload));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Upload Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteUpload")
	public ApiResponse deleteOneUpload(@RequestBody Upload upload) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, uploadService.deleteOneUpload(upload), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Upload Service exception : " + e.getLocalizedMessage());
		}
	}
}
