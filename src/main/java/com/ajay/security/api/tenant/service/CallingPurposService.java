package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CallingPurpos;
import com.ajay.security.api.tenant.repository.CallingPurposRepository;

@Service
public class CallingPurposService {

	@Autowired
	private CallingPurposRepository callingPurposRepository;

	public List<CallingPurpos> getAllCallingPurposs() {
		return callingPurposRepository.findAll();
	}

	public CallingPurpos getOneCallingPurpos(Integer id) {
		return callingPurposRepository.findById(id).get();
	}

	public String saveCallingPurpos(CallingPurpos callingPurpos) {
		return callingPurposRepository.save(callingPurpos) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateCallingPurpos(CallingPurpos callingPurpos) {
		return callingPurposRepository.save(callingPurpos) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCallingPurpos(Integer id) {
		callingPurposRepository.deleteById(id);
		return " successfully deleted!";
	}
}
