package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentParent;
import com.ajay.security.api.tenant.repository.StudentParentRepository;

@Service
@Transactional
public class StudentParentService {

	@Autowired
	private StudentParentRepository studentParentRepository;

	public List<StudentParent> getAllStudentParents() {
		return studentParentRepository.findAll();
	}

	public StudentParent getOneStudentParent(Integer id) {
		return studentParentRepository.findById(id).get();
	}

	public StudentParent saveStudentParent(StudentParent studentParent) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (studentParent.getCreatedAt() == null)
			studentParent.setCreatedAt(currentTimestamp);
		studentParent.setUpdatedAt(currentTimestamp);
		return studentParentRepository.save(studentParent);
	}

	public String deleteOneStudentParent(StudentParent studentParent) {
		String result = null;
		if (studentParentRepository.existsById(studentParent.getId())) {
			studentParentRepository.delete(studentParent);
			result = " StudentParent deleted!";
		} else {
			result = "StudentParent Not Found! or Already deleted!";
		}
		return result;
	}
}
