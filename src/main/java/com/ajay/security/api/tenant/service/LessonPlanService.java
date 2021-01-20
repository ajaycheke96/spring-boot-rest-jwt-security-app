package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.LessonPlan;
import com.ajay.security.api.tenant.repository.LessonPlanRepository;

@Service
@Transactional
public class LessonPlanService {

	@Autowired
	private LessonPlanRepository lessonPlanRepository;

	public List<LessonPlan> getAllLessonPlans() {
		return lessonPlanRepository.findAll();
	}

	public LessonPlan getOneLessonPlan(Integer id) {
		return lessonPlanRepository.findById(id).get();
	}

	public String saveLessonPlan(LessonPlan lessonPlan) {
		return lessonPlanRepository.save(lessonPlan) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateLessonPlan(LessonPlan lessonPlan) {
		return lessonPlanRepository.save(lessonPlan) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneLessonPlan(Integer id) {
		lessonPlanRepository.deleteById(id);
		return " successfully deleted!";
	}
}
