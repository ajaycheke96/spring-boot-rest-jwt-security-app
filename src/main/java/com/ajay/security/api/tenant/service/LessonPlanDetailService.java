package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.LessonPlanDetail;
import com.ajay.security.api.tenant.repository.LessonPlanDetailRepository;

@Service
@Transactional
public class LessonPlanDetailService {

	@Autowired
	private LessonPlanDetailRepository lessonPlanDetailRepository;

	public List<LessonPlanDetail> getAllLessonPlanDetails() {
		return lessonPlanDetailRepository.findAll();
	}

	public LessonPlanDetail getOneLessonPlanDetail(Integer id) {
		return lessonPlanDetailRepository.findById(id).get();
	}

	public String saveLessonPlanDetail(LessonPlanDetail lessonPlanDetail) {
		return lessonPlanDetailRepository.save(lessonPlanDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateLessonPlanDetail(LessonPlanDetail lessonPlanDetail) {
		return lessonPlanDetailRepository.save(lessonPlanDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneLessonPlanDetail(Integer id) {
		lessonPlanDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
