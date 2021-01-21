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

import com.ajay.security.api.tenant.entity.Syllabus;
import com.ajay.security.api.tenant.service.SyllabusService;

@RestController
@RequestMapping("/syllabus")
public class SyllabusController {

	@Autowired
	private SyllabusService syllabusService;

	@GetMapping("/all")
	public List<Syllabus> getAllSyllabus() {
		return syllabusService.getAllSyllabuss();
	}

	@GetMapping("/one/{id}")
	public Syllabus getOneSyllabus(@PathVariable Integer id) {
		return syllabusService.getOneSyllabus(id);
	}

	@PostMapping("/save")
	public String saveSyllabus(@RequestBody Syllabus syllabus) {
		return syllabusService.saveSyllabus(syllabus);
	}

	@PutMapping("/update")
	public String updateSyllabus(@RequestBody Syllabus syllabus) {
		return syllabusService.updateSyllabus(syllabus);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneSyllabus(@PathVariable Integer id) {
		return syllabusService.deleteOneSyllabus(id);
	}
}
