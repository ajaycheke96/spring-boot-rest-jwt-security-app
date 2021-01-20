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

import com.ajay.security.api.tenant.entity.OnlineExam;
import com.ajay.security.api.tenant.service.OnlineExamService;

@RestController
@RequestMapping("/onlineExam")
public class OnlineExamController {

	@Autowired
	private OnlineExamService onlineExamService;

	@GetMapping("/all")
	public List<OnlineExam> getAllOnlineExam() {
		return onlineExamService.getAllOnlineExams();
	}

	@GetMapping("/one/{id}")
	public OnlineExam getOneOnlineExam(@PathVariable Integer id) {
		return onlineExamService.getOneOnlineExam(id);
	}

	@PostMapping("/save")
	public String saveOnlineExam(@RequestBody OnlineExam onlineExam) {
		return onlineExamService.saveOnlineExam(onlineExam);
	}

	@PutMapping("/update")
	public String updateOnlineExam(@RequestBody OnlineExam onlineExam) {
		return onlineExamService.updateOnlineExam(onlineExam);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneOnlineExam(@PathVariable Integer id) {
		return onlineExamService.deleteOneOnlineExam(id);
	}
}
