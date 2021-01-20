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

import com.ajay.security.api.tenant.entity.OnlineExamQuestion;
import com.ajay.security.api.tenant.service.OnlineExamQuestionService;

@RestController
@RequestMapping("/onlineExamQuestion")
public class OnlineExamQuestionController {

	@Autowired
	private OnlineExamQuestionService onlineExamQuestionService;

	@GetMapping("/all")
	public List<OnlineExamQuestion> getAllOnlineExamQuestion() {
		return onlineExamQuestionService.getAllOnlineExamQuestions();
	}

	@GetMapping("/one/{id}")
	public OnlineExamQuestion getOneOnlineExamQuestion(@PathVariable Integer id) {
		return onlineExamQuestionService.getOneOnlineExamQuestion(id);
	}

	@PostMapping("/save")
	public String saveOnlineExamQuestion(@RequestBody OnlineExamQuestion onlineExamQuestion) {
		return onlineExamQuestionService.saveOnlineExamQuestion(onlineExamQuestion);
	}

	@PutMapping("/update")
	public String updateOnlineExamQuestion(@RequestBody OnlineExamQuestion onlineExamQuestion) {
		return onlineExamQuestionService.updateOnlineExamQuestion(onlineExamQuestion);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneOnlineExamQuestion(@PathVariable Integer id) {
		return onlineExamQuestionService.deleteOneOnlineExamQuestion(id);
	}
}
