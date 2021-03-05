package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.OnlineExam;
import com.ajay.security.api.tenant.repository.OnlineExamRepository;

@Service
@Transactional
public class OnlineExamService {

	@Autowired
	private OnlineExamRepository onlineExamRepository;

	public List<OnlineExam> getAllOnlineExams() {
		return onlineExamRepository.findAll();
	}

	public OnlineExam getOneOnlineExam(Integer id) {
		return onlineExamRepository.findById(id).get();
	}

	public OnlineExam saveOnlineExam(OnlineExam onlineExam) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (onlineExam.getCreatedAt() == null)
			onlineExam.setCreatedAt(currentTimestamp);
		onlineExam.setUpdatedAt(currentTimestamp);

		// For onlineExamQuestions list
		if (!onlineExam.getOnlineExamQuestions().isEmpty())
			onlineExam.getOnlineExamQuestions().forEach(onlineExamQuestion -> {
				if (onlineExamQuestion.getCreatedAt() == null)
					onlineExamQuestion.setCreatedAt(currentTimestamp);
				onlineExamQuestion.setUpdatedAt(currentTimestamp);
			});

		return onlineExamRepository.save(onlineExam);
	}

	public String deleteOneOnlineExam(OnlineExam onlineExam) {
		String result = null;
		if (onlineExamRepository.existsById(onlineExam.getId())) {
			onlineExamRepository.delete(onlineExam);
			result = "OnlineExam deleted!";
		} else {
			result = "OnlineExam not found! Or Already deleted";
		}
		return result;
	}
}
