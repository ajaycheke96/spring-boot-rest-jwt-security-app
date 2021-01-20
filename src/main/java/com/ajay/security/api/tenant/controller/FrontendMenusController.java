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

import com.ajay.security.api.tenant.entity.FrontendMenus;
import com.ajay.security.api.tenant.service.FrontendMenusService;

@RestController
@RequestMapping("/frontendMenus")
public class FrontendMenusController {

	@Autowired
	private FrontendMenusService frontendMenusService;

	@GetMapping("/all")
	public List<FrontendMenus> getAllFrontendMenus() {
		return frontendMenusService.getAllFrontendMenuss();
	}

	@GetMapping("/one/{id}")
	public FrontendMenus getOneFrontendMenus(@PathVariable Integer id) {
		return frontendMenusService.getOneFrontendMenus(id);
	}

	@PostMapping("/save")
	public String saveFrontendMenus(@RequestBody FrontendMenus frontendMenus) {
		return frontendMenusService.saveFrontendMenus(frontendMenus);
	}

	@PutMapping("/update")
	public String updateFrontendMenus(@RequestBody FrontendMenus frontendMenus) {
		return frontendMenusService.updateFrontendMenus(frontendMenus);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFrontendMenus(@PathVariable Integer id) {
		return frontendMenusService.deleteOneFrontendMenus(id);
	}
}
