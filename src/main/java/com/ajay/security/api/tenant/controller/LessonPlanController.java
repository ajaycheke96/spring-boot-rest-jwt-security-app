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

import com.ajay.security.api.tenant.entity.LessonPlan;
import com.ajay.security.api.tenant.service.LessonPlanService;

@RestController
@RequestMapping("/lessonPlan")
public class LessonPlanController {

	@Autowired
	private LessonPlanService lessonPlanService;

	@GetMapping("/all")
	public List<LessonPlan> getAllLessonPlan() {
		return lessonPlanService.getAllLessonPlans();
	}

	@GetMapping("/one/{id}")
	public LessonPlan getOneLessonPlan(@PathVariable Integer id) {
		return lessonPlanService.getOneLessonPlan(id);
	}

	@PostMapping("/save")
	public String saveLessonPlan(@RequestBody LessonPlan lessonPlan) {
		return lessonPlanService.saveLessonPlan(lessonPlan);
	}

	@PutMapping("/update")
	public String updateLessonPlan(@RequestBody LessonPlan lessonPlan) {
		return lessonPlanService.updateLessonPlan(lessonPlan);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneLessonPlan(@PathVariable Integer id) {
		return lessonPlanService.deleteOneLessonPlan(id);
	}
}
