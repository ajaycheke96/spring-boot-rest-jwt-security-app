package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public OnlineExamRecord saveOnlineExamRecord(OnlineExamRecord onlineExamRecord) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (onlineExamRecord.getCreatedAt() == null)
			onlineExamRecord.setCreatedAt(currentTimestamp);
		onlineExamRecord.setUpdatedAt(currentTimestamp);
		return onlineExamRecordRepository.save(onlineExamRecord);
	}

	public String deleteOneOnlineExamRecord(OnlineExamRecord onlineExamRecord) {
		String result = null;
		if (onlineExamRecordRepository.existsById(onlineExamRecord.getId())) {
			onlineExamRecordRepository.delete(onlineExamRecord);
			result = " OnlineExamRecord deleted!";
		} else {
			result = "OnlineExamRecord Not Found! or Already deleted!";
		}
		return result;
	}
}
