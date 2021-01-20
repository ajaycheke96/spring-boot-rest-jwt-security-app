package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Student;
import com.ajay.security.api.tenant.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getOneStudent(Integer id) {
		return studentRepository.findById(id).get();
	}

	public String saveStudent(Student student) {
		return studentRepository.save(student) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateStudent(Student student) {
		return studentRepository.save(student) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneStudent(Integer id) {
		studentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
