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

import com.ajay.security.api.tenant.entity.SyllabusDetail;
import com.ajay.security.api.tenant.service.SyllabusDetailService;

@RestController
@RequestMapping("/syllabusDetail")
public class SyllabusDetailController {

	@Autowired
	private SyllabusDetailService syllabusDetailService;

	@GetMapping("/all")
	public List<SyllabusDetail> getAllSyllabusDetail() {
		return syllabusDetailService.getAllSyllabusDetails();
	}

	@GetMapping("/one/{id}")
	public SyllabusDetail getOneSyllabusDetail(@PathVariable Integer id) {
		return syllabusDetailService.getOneSyllabusDetail(id);
	}

	@PostMapping("/save")
	public String saveSyllabusDetail(@RequestBody SyllabusDetail syllabusDetail) {
		return syllabusDetailService.saveSyllabusDetail(syllabusDetail);
	}

	@PutMapping("/update")
	public String updateSyllabusDetail(@RequestBody SyllabusDetail syllabusDetail) {
		return syllabusDetailService.updateSyllabusDetail(syllabusDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneSyllabusDetail(@PathVariable Integer id) {
		return syllabusDetailService.deleteOneSyllabusDetail(id);
	}
}
