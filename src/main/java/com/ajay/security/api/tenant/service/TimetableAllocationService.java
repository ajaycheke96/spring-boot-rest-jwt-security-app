package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TimetableAllocation;
import com.ajay.security.api.tenant.repository.TimetableAllocationRepository;

@Service
@Transactional
public class TimetableAllocationService {

	@Autowired
	private TimetableAllocationRepository timetableAllocationRepository;

	public List<TimetableAllocation> getAllTimetableAllocations() {
		return timetableAllocationRepository.findAll();
	}

	public TimetableAllocation getOneTimetableAllocation(Integer id) {
		return timetableAllocationRepository.findById(id).get();
	}

	public String saveTimetableAllocation(TimetableAllocation timetableAllocation) {
		return timetableAllocationRepository.save(timetableAllocation) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTimetableAllocation(TimetableAllocation timetableAllocation) {
		return timetableAllocationRepository.save(timetableAllocation) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTimetableAllocation(Integer id) {
		timetableAllocationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
