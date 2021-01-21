package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Timetable;
import com.ajay.security.api.tenant.repository.TimetableRepository;

@Service
@Transactional
public class TimetableService {

	@Autowired
	private TimetableRepository timetableRepository;

	public List<Timetable> getAllTimetables() {
		return timetableRepository.findAll();
	}

	public Timetable getOneTimetable(Integer id) {
		return timetableRepository.findById(id).get();
	}

	public String saveTimetable(Timetable timetable) {
		return timetableRepository.save(timetable) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateTimetable(Timetable timetable) {
		return timetableRepository.save(timetable) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneTimetable(Integer id) {
		timetableRepository.deleteById(id);
		return " successfully deleted!";
	}
}
