package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TimetableAllocationDetail;
import com.ajay.security.api.tenant.repository.TimetableAllocationDetailRepository;

@Service
@Transactional
public class TimetableAllocationDetailService {

	@Autowired
	private TimetableAllocationDetailRepository timetableAllocationDetailRepository;

	public List<TimetableAllocationDetail> getAllTimetableAllocationDetails() {
		return timetableAllocationDetailRepository.findAll();
	}

	public TimetableAllocationDetail getOneTimetableAllocationDetail(Integer id) {
		return timetableAllocationDetailRepository.findById(id).get();
	}

	public String saveTimetableAllocationDetail(TimetableAllocationDetail timetableAllocationDetail) {
		return timetableAllocationDetailRepository.save(timetableAllocationDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTimetableAllocationDetail(TimetableAllocationDetail timetableAllocationDetail) {
		return timetableAllocationDetailRepository.save(timetableAllocationDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTimetableAllocationDetail(Integer id) {
		timetableAllocationDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
