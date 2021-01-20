package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Permission;
import com.ajay.security.api.tenant.repository.PermissionRepository;

@Service
@Transactional
public class PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	public List<Permission> getAllPermissions() {
		return permissionRepository.findAll();
	}

	public Permission getOnePermission(Integer id) {
		return permissionRepository.findById(id).get();
	}

	public String savePermission(Permission permission) {
		return permissionRepository.save(permission) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updatePermission(Permission permission) {
		return permissionRepository.save(permission) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOnePermission(Integer id) {
		permissionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
