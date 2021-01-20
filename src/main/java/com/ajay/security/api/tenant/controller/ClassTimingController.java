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

import com.ajay.security.api.tenant.entity.ClassTiming;
import com.ajay.security.api.tenant.service.ClassTimingService;

@RestController
@RequestMapping("/classTiming")
public class ClassTimingController {

	@Autowired
	private ClassTimingService classTimingService;

	@GetMapping("/all")
	public List<ClassTiming> getAllClassTiming() {
		return classTimingService.getAllClassTimings();
	}

	@GetMapping("/one/{id}")
	public ClassTiming getOneClassTiming(@PathVariable Integer id) {
		return classTimingService.getOneClassTiming(id);
	}

	@PostMapping("/save")
	public String saveClassTiming(@RequestBody ClassTiming classTiming) {
		return classTimingService.saveClassTiming(classTiming);
	}

	@PutMapping("/update")
	public String updateClassTiming(@RequestBody ClassTiming classTiming) {
		return classTimingService.updateClassTiming(classTiming);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneClassTiming(@PathVariable Integer id) {
		return classTimingService.deleteOneClassTiming(id);
	}
}
