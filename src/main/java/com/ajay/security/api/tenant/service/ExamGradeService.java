package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamGrade;
import com.ajay.security.api.tenant.repository.ExamGradeRepository;

@Service
@Transactional
public class ExamGradeService {

	@Autowired
	private ExamGradeRepository examGradeRepository;

	public List<ExamGrade> getAllExamGrades() {
		return examGradeRepository.findAll();
	}

	public ExamGrade getOneExamGrade(Integer id) {
		return examGradeRepository.findById(id).get();
	}

	public ExamGrade saveExamGrade(ExamGrade examGrade) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (examGrade.getCreatedAt() == null)
			examGrade.setCreatedAt(currentTimestamp);
		examGrade.setUpdatedAt(currentTimestamp);

		if (!examGrade.getExamGradeDetails().isEmpty())
			examGrade.getExamGradeDetails().forEach(examGradeDetail -> {
				if (examGradeDetail.getCreatedAt() == null)
					examGradeDetail.setCreatedAt(currentTimestamp);
				examGradeDetail.setUpdatedAt(currentTimestamp);
			});
		return examGradeRepository.save(examGrade);
	}

	public String deleteOneExamGrade(ExamGrade examGrade) {
		String result = null;
		if (examGradeRepository.existsById(examGrade.getId())) {
			examGradeRepository.delete(examGrade);
			result = " ExamGrade deleted!";
		} else {
			result = "ExamGrade Not Found! or Already deleted!";
		}
		return result;
	}
}
