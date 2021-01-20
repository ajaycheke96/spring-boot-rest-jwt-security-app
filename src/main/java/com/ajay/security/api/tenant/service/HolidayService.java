package com.ajay.security.api.tenant.service;

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

	public String saveHoliday(Holiday holiday) {
		return holidayRepository.save(holiday) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateHoliday(Holiday holiday) {
		return holidayRepository.save(holiday) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneHoliday(Integer id) {
		holidayRepository.deleteById(id);
		return " successfully deleted!";
	}
}
