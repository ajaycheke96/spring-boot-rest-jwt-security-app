package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.AcademicSession;
import com.ajay.security.api.tenant.repository.AcademicSessionRepository;

@Service
@Transactional
public class AcademicSessionService {

	@Autowired
	private AcademicSessionRepository academicSessionRepository;

	public List<AcademicSession> getAllAcademicSessions() {
		List<AcademicSession> list = academicSessionRepository.findAll();
		return list;
	}

	public AcademicSession getOneAcademicSession(Integer id) {
		return academicSessionRepository.findById(id).get();
	}

	public String saveAcademicSession(AcademicSession academicSession) {
		return academicSessionRepository.save(academicSession) != null ? "Academic Session successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateAcademicSession(AcademicSession academicSession) {
		return academicSessionRepository.save(academicSession) != null ? "Academic Session successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneAcademicSession(Integer id) {
		academicSessionRepository.deleteById(id);
		return "Academic Session successfully deleted!";
	}
}
