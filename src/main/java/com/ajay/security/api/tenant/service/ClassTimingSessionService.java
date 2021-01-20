package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.ClassTimingSession;
import com.ajay.security.api.tenant.repository.ClassTimingSessionRepository;

@Service
public class ClassTimingSessionService {

	@Autowired
	private ClassTimingSessionRepository classTimingSessionRepository;

	public List<ClassTimingSession> getAllClassTimingSessions() {
		return classTimingSessionRepository.findAll();
	}

	public ClassTimingSession getOneClassTimingSession(Integer id) {
		return classTimingSessionRepository.findById(id).get();
	}

	public String saveClassTimingSession(ClassTimingSession classTimingSession) {
		return classTimingSessionRepository.save(classTimingSession) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateClassTimingSession(ClassTimingSession classTimingSession) {
		return classTimingSessionRepository.save(classTimingSession) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneClassTimingSession(Integer id) {
		classTimingSessionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
