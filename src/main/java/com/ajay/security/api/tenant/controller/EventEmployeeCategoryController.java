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

import com.ajay.security.api.tenant.entity.EventEmployeeCategory;
import com.ajay.security.api.tenant.service.EventEmployeeCategoryService;

@RestController
@RequestMapping("/eventEmployeeCategory")
public class EventEmployeeCategoryController {

	@Autowired
	private EventEmployeeCategoryService eventEmployeeCategoryService;

	@GetMapping("/all")
	public List<EventEmployeeCategory> getAllEventEmployeeCategory() {
		return eventEmployeeCategoryService.getAllEventEmployeeCategorys();
	}

	@GetMapping("/one/{id}")
	public EventEmployeeCategory getOneEventEmployeeCategory(@PathVariable Integer id) {
		return eventEmployeeCategoryService.getOneEventEmployeeCategory(id);
	}

	@PostMapping("/save")
	public String saveEventEmployeeCategory(@RequestBody EventEmployeeCategory eventEmployeeCategory) {
		return eventEmployeeCategoryService.saveEventEmployeeCategory(eventEmployeeCategory);
	}

	@PutMapping("/update")
	public String updateEventEmployeeCategory(@RequestBody EventEmployeeCategory eventEmployeeCategory) {
		return eventEmployeeCategoryService.updateEventEmployeeCategory(eventEmployeeCategory);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEventEmployeeCategory(@PathVariable Integer id) {
		return eventEmployeeCategoryService.deleteOneEventEmployeeCategory(id);
	}
}
