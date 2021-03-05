package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public ClassTeacher saveClassTeacher(ClassTeacher classTeacher) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (classTeacher.getCreatedAt() == null)
			classTeacher.setCreatedAt(currentTimestamp);
		classTeacher.setUpdatedAt(currentTimestamp);
		return classTeacherRepository.save(classTeacher);
	}

	public String deleteOneClassTeacher(ClassTeacher classTeacher) {
		String result = null;
		if (classTeacherRepository.existsById(classTeacher.getId())) {
			classTeacherRepository.delete(classTeacher);
			result = " ClassTeacher deleted!";
		} else {
			result = "ClassTeacher Not Found! or Already deleted!";
		}
		return result;
	}
}
