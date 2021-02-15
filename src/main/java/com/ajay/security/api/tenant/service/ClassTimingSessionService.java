package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public ClassTimingSession saveClassTimingSession(ClassTimingSession classTimingSession) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (classTimingSession.getCreatedAt() == null)
			classTimingSession.setCreatedAt(currentTimestamp);
		classTimingSession.setUpdatedAt(currentTimestamp);

		if (classTimingSession.getClassTiming().getId() == null)
			classTimingSession.getClassTiming().setCreatedAt(currentTimestamp);
		classTimingSession.getClassTiming().setUpdatedAt(currentTimestamp);
		return classTimingSessionRepository.save(classTimingSession);
	}

	public String deleteOneClassTimingSession(ClassTimingSession classTimingSession) {
		classTimingSessionRepository.delete(classTimingSession);
		return " successfully deleted!";
	}
}
