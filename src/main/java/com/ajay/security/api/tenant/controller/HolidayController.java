package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Holiday;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.HolidayService;

@RestController
@RequestMapping("/holiday")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HolidayController {

	@Autowired
	private HolidayService holidayService;

	@GetMapping("/listAllHoliday")
	public ApiResponse getAllHoliday() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Holiday", holidayService.getAllHolidays());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Holiday Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneHoliday(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Holiday", holidayService.getOneHoliday(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Holiday Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveHoliday")
	public ApiResponse saveHoliday(@RequestBody Holiday holiday) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Holiday saved!",
					holidayService.saveHoliday(holiday));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Holiday Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateHoliday")
	public ApiResponse updateHoliday(@RequestBody Holiday holiday) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Holiday updated!",
					holidayService.saveHoliday(holiday));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Holiday Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteHoliday")
	public ApiResponse deleteOneHoliday(@RequestBody Holiday holiday) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, holidayService.deleteOneHoliday(holiday), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Holiday Service exception : " + e.getLocalizedMessage());
		}
	}
}
