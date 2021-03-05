package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public ExamSchedule saveExamSchedule(ExamSchedule examSchedule) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (examSchedule.getCreatedAt() == null)
			examSchedule.setCreatedAt(currentTimestamp);
		examSchedule.setUpdatedAt(currentTimestamp);
		return examScheduleRepository.save(examSchedule);
	}

	public String deleteOneExamSchedule(ExamSchedule examSchedule) {
		String result = null;
		if (examScheduleRepository.existsById(examSchedule.getId())) {
			examScheduleRepository.delete(examSchedule);
			result = " ExamSchedule deleted!";
		} else {
			result = "ExamSchedule Not Found! or Already deleted!";
		}
		return result;
	}
}
