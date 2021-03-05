package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Holiday;
import com.ajay.security.api.tenant.repository.HolidayRepository;

@Service
@Transactional
public class HolidayService {

	@Autowired
	private HolidayRepository holidayRepository;

	public List<Holiday> getAllHolidays() {
		return holidayRepository.findAll();
	}

	public Holiday getOneHoliday(Integer id) {
		return holidayRepository.findById(id).get();
	}

	public Holiday saveHoliday(Holiday holiday) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (holiday.getCreatedAt() == null)
			holiday.setCreatedAt(currentTimestamp);
		holiday.setUpdatedAt(currentTimestamp);
		return holidayRepository.save(holiday);
	}

	public String deleteOneHoliday(Holiday holiday) {
		String result = null;
		if (holidayRepository.existsById(holiday.getId())) {
			holidayRepository.delete(holiday);
			result = " Holiday deleted!";
		} else {
			result = "Holiday Not Found! or Already deleted!";
		}
		return result;
	}
}
