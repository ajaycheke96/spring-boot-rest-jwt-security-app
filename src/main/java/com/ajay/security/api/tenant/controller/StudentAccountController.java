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

import com.ajay.security.api.tenant.entity.StudentAccount;
import com.ajay.security.api.tenant.service.StudentAccountService;

@RestController
@RequestMapping("/studentAccount")
public class StudentAccountController {

	@Autowired
	private StudentAccountService studentAccountService;

	@GetMapping("/all")
	public List<StudentAccount> getAllStudentAccount() {
		return studentAccountService.getAllStudentAccounts();
	}

	@GetMapping("/one/{id}")
	public StudentAccount getOneStudentAccount(@PathVariable Integer id) {
		return studentAccountService.getOneStudentAccount(id);
	}

	@PostMapping("/save")
	public String saveStudentAccount(@RequestBody StudentAccount studentAccount) {
		return studentAccountService.saveStudentAccount(studentAccount);
	}

	@PutMapping("/update")
	public String updateStudentAccount(@RequestBody StudentAccount studentAccount) {
		return studentAccountService.updateStudentAccount(studentAccount);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentAccount(@PathVariable Integer id) {
		return studentAccountService.deleteOneStudentAccount(id);
	}
}
