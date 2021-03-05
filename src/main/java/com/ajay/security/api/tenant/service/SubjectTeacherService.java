package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.SubjectTeacher;
import com.ajay.security.api.tenant.repository.SubjectTeacherRepository;

@Service
@Transactional
public class SubjectTeacherService {

	@Autowired
	private SubjectTeacherRepository subjectTeacherRepository;

	public List<SubjectTeacher> getAllSubjectTeachers() {
		return subjectTeacherRepository.findAll();
	}

	public SubjectTeacher getOneSubjectTeacher(Integer id) {
		return subjectTeacherRepository.findById(id).get();
	}

	public SubjectTeacher saveSubjectTeacher(SubjectTeacher subjectTeacher) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (subjectTeacher.getCreatedAt() == null)
			subjectTeacher.setCreatedAt(currentTimestamp);
		subjectTeacher.setUpdatedAt(currentTimestamp);
		return subjectTeacherRepository.save(subjectTeacher);
	}

	public String deleteOneSubjectTeacher(SubjectTeacher subjectTeacher) {
		String result = null;
		if (subjectTeacherRepository.existsById(subjectTeacher.getId())) {
			subjectTeacherRepository.delete(subjectTeacher);
			result = " SubjectTeacher deleted!";
		} else {
			result = "SubjectTeacher Not Found! or Already deleted!";
		}
		return result;
	}
}
