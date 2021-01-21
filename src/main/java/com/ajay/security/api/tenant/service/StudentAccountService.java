package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentAccount;
import com.ajay.security.api.tenant.repository.StudentAccountRepository;

@Service
@Transactional
public class StudentAccountService {

	@Autowired
	private StudentAccountRepository studentAccountRepository;

	public List<StudentAccount> getAllStudentAccounts() {
		return studentAccountRepository.findAll();
	}

	public StudentAccount getOneStudentAccount(Integer id) {
		return studentAccountRepository.findById(id).get();
	}

	public String saveStudentAccount(StudentAccount studentAccount) {
		return studentAccountRepository.save(studentAccount) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentAccount(StudentAccount studentAccount) {
		return studentAccountRepository.save(studentAccount) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentAccount(Integer id) {
		studentAccountRepository.deleteById(id);
		return " successfully deleted!";
	}
}
