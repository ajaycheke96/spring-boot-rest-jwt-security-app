package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.OnlineExamRecord;
import com.ajay.security.api.tenant.repository.OnlineExamRecordRepository;

@Service
@Transactional
public class OnlineExamRecordService {

	@Autowired
	private OnlineExamRecordRepository onlineExamRecordRepository;

	public List<OnlineExamRecord> getAllOnlineExamRecords() {
		return onlineExamRecordRepository.findAll();
	}

	public OnlineExamRecord getOneOnlineExamRecord(Integer id) {
		return onlineExamRecordRepository.findById(id).get();
	}

	public String saveOnlineExamRecord(OnlineExamRecord onlineExamRecord) {
		return onlineExamRecordRepository.save(onlineExamRecord) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateOnlineExamRecord(OnlineExamRecord onlineExamRecord) {
		return onlineExamRecordRepository.save(onlineExamRecord) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneOnlineExamRecord(Integer id) {
		onlineExamRecordRepository.deleteById(id);
		return " successfully deleted!";
	}
}
