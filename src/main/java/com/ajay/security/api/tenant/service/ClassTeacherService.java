package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.ClassTeacher;
import com.ajay.security.api.tenant.repository.ClassTeacherRepository;

@Service
public class ClassTeacherService {

	@Autowired
	private ClassTeacherRepository classTeacherRepository;

	public List<ClassTeacher> getAllClassTeachers() {
		return classTeacherRepository.findAll();
	}

	public ClassTeacher getOneClassTeacher(Integer id) {
		return classTeacherRepository.findById(id).get();
	}

	public String saveClassTeacher(ClassTeacher classTeacher) {
		return classTeacherRepository.save(classTeacher) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateClassTeacher(ClassTeacher classTeacher) {
		return classTeacherRepository.save(classTeacher) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneClassTeacher(Integer id) {
		classTeacherRepository.deleteById(id);
		return " successfully deleted!";
	}
}
