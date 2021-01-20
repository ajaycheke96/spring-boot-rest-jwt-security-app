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

import com.ajay.security.api.tenant.entity.Permission;
import com.ajay.security.api.tenant.service.PermissionService;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@GetMapping("/all")
	public List<Permission> getAllPermission() {
		return permissionService.getAllPermissions();
	}

	@GetMapping("/one/{id}")
	public Permission getOnePermission(@PathVariable Integer id) {
		return permissionService.getOnePermission(id);
	}

	@PostMapping("/save")
	public String savePermission(@RequestBody Permission permission) {
		return permissionService.savePermission(permission);
	}

	@PutMapping("/update")
	public String updatePermission(@RequestBody Permission permission) {
		return permissionService.updatePermission(permission);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOnePermission(@PathVariable Integer id) {
		return permissionService.deleteOnePermission(id);
	}
}
