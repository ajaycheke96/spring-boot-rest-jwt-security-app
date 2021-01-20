package com.ajay.security.api.tenant.service;

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

	public String saveOnlineExam(OnlineExam onlineExam) {
		return onlineExamRepository.save(onlineExam) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateOnlineExam(OnlineExam onlineExam) {
		return onlineExamRepository.save(onlineExam) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneOnlineExam(Integer id) {
		onlineExamRepository.deleteById(id);
		return " successfully deleted!";
	}
}
