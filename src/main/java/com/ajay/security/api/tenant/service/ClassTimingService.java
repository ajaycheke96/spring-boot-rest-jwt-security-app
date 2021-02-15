package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public ClassTiming saveClassTiming(ClassTiming classTiming) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (classTiming.getCreatedAt() == null) {
			classTiming.setCreatedAt(currentTimestamp);
		}
		classTiming.setUpdatedAt(currentTimestamp);

//		classTiming.getClassTimingSessions().forEach(cts -> {
//			cts.setCreatedAt(currentTimestamp);
//			cts.setUpdatedAt(currentTimestamp);
//		});

		return classTimingRepository.save(classTiming);
	}

	public String deleteOneClassTiming(ClassTiming classTiming) {
		classTimingRepository.delete(classTiming);
		return " successfully deleted!";
	}
}
