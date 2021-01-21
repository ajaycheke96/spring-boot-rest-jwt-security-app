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

import com.ajay.security.api.tenant.entity.SyllabusTopic;
import com.ajay.security.api.tenant.service.SyllabusTopicService;

@RestController
@RequestMapping("/syllabusTopic")
public class SyllabusTopicController {

	@Autowired
	private SyllabusTopicService syllabusTopicService;

	@GetMapping("/all")
	public List<SyllabusTopic> getAllSyllabusTopic() {
		return syllabusTopicService.getAllSyllabusTopics();
	}

	@GetMapping("/one/{id}")
	public SyllabusTopic getOneSyllabusTopic(@PathVariable Integer id) {
		return syllabusTopicService.getOneSyllabusTopic(id);
	}

	@PostMapping("/save")
	public String saveSyllabusTopic(@RequestBody SyllabusTopic syllabusTopic) {
		return syllabusTopicService.saveSyllabusTopic(syllabusTopic);
	}

	@PutMapping("/update")
	public String updateSyllabusTopic(@RequestBody SyllabusTopic syllabusTopic) {
		return syllabusTopicService.updateSyllabusTopic(syllabusTopic);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneSyllabusTopic(@PathVariable Integer id) {
		return syllabusTopicService.deleteOneSyllabusTopic(id);
	}
}
