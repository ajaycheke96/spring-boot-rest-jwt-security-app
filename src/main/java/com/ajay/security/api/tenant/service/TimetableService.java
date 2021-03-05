package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Timetable saveTimetable(Timetable timetable) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (timetable.getCreatedAt() == null)
			timetable.setCreatedAt(currentTimestamp);
		timetable.setUpdatedAt(currentTimestamp);

		// For timetableAllocations list
		if (!timetable.getTimetableAllocations().isEmpty())
			timetable.getTimetableAllocations().forEach(timetableAllocation -> {
				if (timetableAllocation.getCreatedAt() == null)
					timetableAllocation.setCreatedAt(currentTimestamp);
				timetableAllocation.setUpdatedAt(currentTimestamp);

				// For timetableAllocationDetails list
				if (!timetableAllocation.getTimetableAllocationDetails().isEmpty())
					timetableAllocation.getTimetableAllocationDetails().forEach(timetableAllocationDetail -> {
						if (timetableAllocationDetail.getCreatedAt() == null)
							timetableAllocationDetail.setCreatedAt(currentTimestamp);
						timetableAllocationDetail.setUpdatedAt(currentTimestamp);
					});
			});
		return timetableRepository.save(timetable);
	}

	public String deleteOneTimetable(Timetable timetable) {
		String result = null;
		if (timetableRepository.existsById(timetable.getId())) {
			timetableRepository.delete(timetable);
			result = " Timetable deleted!";
		} else {
			result = "Timetable Not Found! or Already deleted!";
		}
		return result;
	}
}
