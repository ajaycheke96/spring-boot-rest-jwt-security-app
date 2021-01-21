package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentGroupCollection;
import com.ajay.security.api.tenant.repository.StudentGroupCollectionRepository;

@Service
@Transactional
public class StudentGroupCollectionService {

	@Autowired
	private StudentGroupCollectionRepository studentGroupCollectionRepository;

	public List<StudentGroupCollection> getAllStudentGroupCollections() {
		return studentGroupCollectionRepository.findAll();
	}

	public StudentGroupCollection getOneStudentGroupCollection(Integer id) {
		return studentGroupCollectionRepository.findById(id).get();
	}

	public String saveStudentGroupCollection(StudentGroupCollection studentGroupCollection) {
		return studentGroupCollectionRepository.save(studentGroupCollection) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentGroupCollection(StudentGroupCollection studentGroupCollection) {
		return studentGroupCollectionRepository.save(studentGroupCollection) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentGroupCollection(Integer id) {
		studentGroupCollectionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
