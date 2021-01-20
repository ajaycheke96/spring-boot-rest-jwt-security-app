package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CommunicationCourse;
import com.ajay.security.api.tenant.repository.CommunicationCourseRepository;

@Service
public class CommunicationCourseService {

	@Autowired
	private CommunicationCourseRepository communicationCourseRepository;

	public List<CommunicationCourse> getAllCommunicationCourses() {
		return communicationCourseRepository.findAll();
	}

	public CommunicationCourse getOneCommunicationCourse(Integer id) {
		return communicationCourseRepository.findById(id).get();
	}

	public String saveCommunicationCourse(CommunicationCourse communicationCourse) {
		return communicationCourseRepository.save(communicationCourse) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateCommunicationCourse(CommunicationCourse communicationCourse) {
		return communicationCourseRepository.save(communicationCourse) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCommunicationCourse(Integer id) {
		communicationCourseRepository.deleteById(id);
		return " successfully deleted!";
	}
}
