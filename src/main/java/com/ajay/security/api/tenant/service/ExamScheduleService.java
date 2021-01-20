package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamSchedule;
import com.ajay.security.api.tenant.repository.ExamScheduleRepository;

@Service
@Transactional
public class ExamScheduleService {

	@Autowired
	private ExamScheduleRepository examScheduleRepository;

	public List<ExamSchedule> getAllExamSchedules() {
		return examScheduleRepository.findAll();
	}

	public ExamSchedule getOneExamSchedule(Integer id) {
		return examScheduleRepository.findById(id).get();
	}

	public String saveExamSchedule(ExamSchedule examSchedule) {
		return examScheduleRepository.save(examSchedule) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateExamSchedule(ExamSchedule examSchedule) {
		return examScheduleRepository.save(examSchedule) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneExamSchedule(Integer id) {
		examScheduleRepository.deleteById(id);
		return " successfully deleted!";
	}
}
