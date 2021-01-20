package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.Holiday;
import com.ajay.security.api.tenant.service.HolidayService;

@RestController
@RequestMapping("/holiday")
public class HolidayController {

	@Autowired
	private HolidayService holidayService;

	@GetMapping("/all")
	public List<Holiday> getAllHoliday() {
		return holidayService.getAllHolidays();
	}

	@GetMapping("/one/{id}")
	public Holiday getOneHoliday(@PathVariable Integer id) {
		return holidayService.getOneHoliday(id);
	}

	@PostMapping("/save")
	public String saveHoliday(@RequestBody Holiday holiday) {
		return holidayService.saveHoliday(holiday);
	}

	@PutMapping("/update")
	public String updateHoliday(@RequestBody Holiday holiday) {
		return holidayService.updateHoliday(holiday);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneHoliday(@PathVariable Integer id) {
		return holidayService.deleteOneHoliday(id);
	}
}
