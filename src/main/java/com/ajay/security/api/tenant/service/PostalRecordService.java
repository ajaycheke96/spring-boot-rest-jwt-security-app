package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.PostalRecord;
import com.ajay.security.api.tenant.repository.PostalRecordRepository;

@Service
@Transactional
public class PostalRecordService {

	@Autowired
	private PostalRecordRepository postalRecordRepository;

	public List<PostalRecord> getAllPostalRecords() {
		return postalRecordRepository.findAll();
	}

	public PostalRecord getOnePostalRecord(Integer id) {
		return postalRecordRepository.findById(id).get();
	}

	public String savePostalRecord(PostalRecord postalRecord) {
		return postalRecordRepository.save(postalRecord) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updatePostalRecord(PostalRecord postalRecord) {
		return postalRecordRepository.save(postalRecord) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOnePostalRecord(Integer id) {
		postalRecordRepository.deleteById(id);
		return " successfully deleted!";
	}
}
