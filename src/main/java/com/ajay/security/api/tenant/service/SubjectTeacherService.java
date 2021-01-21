package com.ajay.security.api.tenant.service;

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

	public String saveSubjectTeacher(SubjectTeacher subjectTeacher) {
		return subjectTeacherRepository.save(subjectTeacher) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateSubjectTeacher(SubjectTeacher subjectTeacher) {
		return subjectTeacherRepository.save(subjectTeacher) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneSubjectTeacher(Integer id) {
		subjectTeacherRepository.deleteById(id);
		return " successfully deleted!";
	}
}
