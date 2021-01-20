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

import com.ajay.security.api.tenant.entity.ClassTimingSession;
import com.ajay.security.api.tenant.service.ClassTimingSessionService;

@RestController
@RequestMapping("/classTimingSession")
public class ClassTimingSessionController {

	@Autowired
	private ClassTimingSessionService classTimingSessionService;

	@GetMapping("/all")
	public List<ClassTimingSession> getAllClassTimingSession() {
		return classTimingSessionService.getAllClassTimingSessions();
	}

	@GetMapping("/one/{id}")
	public ClassTimingSession getOneClassTimingSession(@PathVariable Integer id) {
		return classTimingSessionService.getOneClassTimingSession(id);
	}

	@PostMapping("/save")
	public String saveClassTimingSession(@RequestBody ClassTimingSession classTimingSession) {
		return classTimingSessionService.saveClassTimingSession(classTimingSession);
	}

	@PutMapping("/update")
	public String updateClassTimingSession(@RequestBody ClassTimingSession classTimingSession) {
		return classTimingSessionService.updateClassTimingSession(classTimingSession);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneClassTimingSession(@PathVariable Integer id) {
		return classTimingSessionService.deleteOneClassTimingSession(id);
	}
}
