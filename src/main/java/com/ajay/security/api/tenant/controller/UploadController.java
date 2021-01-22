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

import com.ajay.security.api.tenant.entity.Upload;
import com.ajay.security.api.tenant.service.UploadService;

@RestController
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@GetMapping("/all")
	public List<Upload> getAllUpload() {
		return uploadService.getAllUploads();
	}

	@GetMapping("/one/{id}")
	public Upload getOneUpload(@PathVariable Integer id) {
		return uploadService.getOneUpload(id);
	}

	@PostMapping("/save")
	public String saveUpload(@RequestBody Upload upload) {
		return uploadService.saveUpload(upload);
	}

	@PutMapping("/update")
	public String updateUpload(@RequestBody Upload upload) {
		return uploadService.updateUpload(upload);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneUpload(@PathVariable Integer id) {
		return uploadService.deleteOneUpload(id);
	}
}
