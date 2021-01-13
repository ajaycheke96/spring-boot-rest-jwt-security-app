package com.ajay.security.api.mastertenant.controller;

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

import com.ajay.security.api.mastertenant.entity.MasterTenantEntity;
import com.ajay.security.api.mastertenant.service.MasterTenantService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/tenant/api")
public class MasterTenantController {

	@Autowired
	private MasterTenantService masterTenantService;
	
	@GetMapping("/all")
	public List<MasterTenantEntity> getAllTenants(){
		return masterTenantService.findAllTenants();
	}
	
	@GetMapping("/one/{id}")
	public MasterTenantEntity getOneTenant(@PathVariable Integer id) throws NotFoundException{
		return masterTenantService.findById(id);
	}
	
	@PostMapping("/save")
	public String saveTenant(@RequestBody MasterTenantEntity masterTenantEntity) {
		return masterTenantService.saveOrUpdateTenant(masterTenantEntity);
	}
	
	@PutMapping("/update")
	public String updateTenant(@RequestBody MasterTenantEntity masterTenantEntity) {
		return masterTenantService.saveOrUpdateTenant(masterTenantEntity);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTenant(@PathVariable Integer id) {
		return masterTenantService.deleteTenantById(id);
	}
}
