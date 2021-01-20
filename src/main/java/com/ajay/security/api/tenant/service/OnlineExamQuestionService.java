package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.OnlineExamQuestion;
import com.ajay.security.api.tenant.repository.OnlineExamQuestionRepository;

@Service
@Transactional
public class OnlineExamQuestionService {

	@Autowired
	private OnlineExamQuestionRepository onlineExamQuestionRepository;

	public List<OnlineExamQuestion> getAllOnlineExamQuestions() {
		return onlineExamQuestionRepository.findAll();
	}

	public OnlineExamQuestion getOneOnlineExamQuestion(Integer id) {
		return onlineExamQuestionRepository.findById(id).get();
	}

	public String saveOnlineExamQuestion(OnlineExamQuestion onlineExamQuestion) {
		return onlineExamQuestionRepository.save(onlineExamQuestion) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateOnlineExamQuestion(OnlineExamQuestion onlineExamQuestion) {
		return onlineExamQuestionRepository.save(onlineExamQuestion) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneOnlineExamQuestion(Integer id) {
		onlineExamQuestionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
