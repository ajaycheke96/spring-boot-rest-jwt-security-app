package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.ClassTiming;
import com.ajay.security.api.tenant.repository.ClassTimingRepository;

@Service
public class ClassTimingService {

	@Autowired
	private ClassTimingRepository classTimingRepository;

	public List<ClassTiming> getAllClassTimings() {
		return classTimingRepository.findAll();
	}

	public ClassTiming getOneClassTiming(Integer id) {
		return classTimingRepository.findById(id).get();
	}

	public String saveClassTiming(ClassTiming classTiming) {
		return classTimingRepository.save(classTiming) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateClassTiming(ClassTiming classTiming) {
		return classTimingRepository.save(classTiming) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneClassTiming(Integer id) {
		classTimingRepository.deleteById(id);
		return " successfully deleted!";
	}
}
