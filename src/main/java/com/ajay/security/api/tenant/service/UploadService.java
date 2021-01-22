package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Upload;
import com.ajay.security.api.tenant.repository.UploadRepository;

@Service
@Transactional
public class UploadService {

	@Autowired
	private UploadRepository uploadRepository;

	public List<Upload> getAllUploads() {
		return uploadRepository.findAll();
	}

	public Upload getOneUpload(Integer id) {
		return uploadRepository.findById(id).get();
	}

	public String saveUpload(Upload upload) {
		return uploadRepository.save(upload) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateUpload(Upload upload) {
		return uploadRepository.save(upload) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneUpload(Integer id) {
		uploadRepository.deleteById(id);
		return " successfully deleted!";
	}
}
