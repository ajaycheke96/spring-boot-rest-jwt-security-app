package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public LessonPlan saveLessonPlan(LessonPlan lessonPlan) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (lessonPlan.getCreatedAt() == null)
			lessonPlan.setCreatedAt(currentTimestamp);
		lessonPlan.setUpdatedAt(currentTimestamp);

		// For lessonPlanDetails list
		if (!lessonPlan.getLessonPlanDetails().isEmpty())
			lessonPlan.getLessonPlanDetails().forEach(lessonPlanDetail -> {
				if (lessonPlanDetail.getCreatedAt() == null)
					lessonPlanDetail.setCreatedAt(currentTimestamp);
				lessonPlanDetail.setUpdatedAt(currentTimestamp);
			});
		return lessonPlanRepository.save(lessonPlan);
	}

	public String deleteOneLessonPlan(LessonPlan lessonPlan) {
		String result = null;
		if (lessonPlanRepository.existsById(lessonPlan.getId())) {
			lessonPlanRepository.delete(lessonPlan);
			result = "LessonPlan deleted!";
		} else {
			result = "LessonPlan not found! Or Already deleted!";
		}
		return result;
	}
}
