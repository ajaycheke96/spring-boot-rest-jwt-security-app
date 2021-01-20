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

import com.ajay.security.api.tenant.entity.LessonPlanDetail;
import com.ajay.security.api.tenant.service.LessonPlanDetailService;

@RestController
@RequestMapping("/lessonPlanDetail")
public class LessonPlanDetailController {

	@Autowired
	private LessonPlanDetailService lessonPlanDetailService;

	@GetMapping("/all")
	public List<LessonPlanDetail> getAllLessonPlanDetail() {
		return lessonPlanDetailService.getAllLessonPlanDetails();
	}

	@GetMapping("/one/{id}")
	public LessonPlanDetail getOneLessonPlanDetail(@PathVariable Integer id) {
		return lessonPlanDetailService.getOneLessonPlanDetail(id);
	}

	@PostMapping("/save")
	public String saveLessonPlanDetail(@RequestBody LessonPlanDetail lessonPlanDetail) {
		return lessonPlanDetailService.saveLessonPlanDetail(lessonPlanDetail);
	}

	@PutMapping("/update")
	public String updateLessonPlanDetail(@RequestBody LessonPlanDetail lessonPlanDetail) {
		return lessonPlanDetailService.updateLessonPlanDetail(lessonPlanDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneLessonPlanDetail(@PathVariable Integer id) {
		return lessonPlanDetailService.deleteOneLessonPlanDetail(id);
	}
}
