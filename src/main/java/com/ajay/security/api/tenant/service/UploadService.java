package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Upload saveUpload(Upload upload) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (upload.getCreatedAt() == null)
			upload.setCreatedAt(currentTimestamp);
		upload.setUpdatedAt(currentTimestamp);
		return uploadRepository.save(upload);
	}

	public String deleteOneUpload(Upload upload) {
		String result = null;
		if (uploadRepository.existsById(upload.getId())) {
			uploadRepository.delete(upload);
			result = " Upload deleted!";
		} else {
			result = "Upload Not Found! or Already deleted!";
		}
		return result;
	}
}
