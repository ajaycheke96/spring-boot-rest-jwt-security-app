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

import com.ajay.security.api.tenant.entity.AcademicSession;
import com.ajay.security.api.tenant.service.AcademicSessionService;

@RestController
@RequestMapping("/academicSession")
public class AcademicSessionController {

	@Autowired
	private AcademicSessionService academicSessionService;

	@GetMapping("/all")
	public List<AcademicSession> getAllAcademicSessions() {
		return academicSessionService.getAllAcademicSessions();
	}

	@GetMapping("/one/{id}")
	public AcademicSession getOneAcademicSession(@PathVariable Integer id) {
		return academicSessionService.getOneAcademicSession(id);
	}

	@PostMapping("/save")
	public String saveAcademicSession(@RequestBody AcademicSession academicSession) {
		return academicSessionService.saveAcademicSession(academicSession);
	}

	@PutMapping("/update")
	public String updateAcademicSession(@RequestBody AcademicSession academicSession) {
		return academicSessionService.updateAcademicSession(academicSession);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneAcademicSession(@PathVariable Integer id) {
		return academicSessionService.deleteOneAcademicSession(id);
	}
}