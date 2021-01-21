//package com.ajay.security.api.tenant.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ajay.security.api.tenant.entity.ModelHasPermission;
//import com.ajay.security.api.tenant.entity.ModelHasPermissionPK;
//import com.ajay.security.api.tenant.repository.ModelHasPermissionRepository;
//
//@Service
//@Transactional
//public class ModelHasPermissionService {
//
//	@Autowired
//	private ModelHasPermissionRepository modelHasPermissionRepository;
//
//	public List<ModelHasPermission> getAllModelHasPermissions() {
//		return modelHasPermissionRepository.findAll();
//	}
//
//	public ModelHasPermission getOneModelHasPermission(ModelHasPermissionPK id) {
//		return modelHasPermissionRepository.findById(id).get();
//	}
//
//	public String saveModelHasPermission(ModelHasPermission modelHasPermission) {
//		return modelHasPermissionRepository.save(modelHasPermission) != null ? " successfully saved!"
//				: "Failed! Please try again!!";
//	}
//
//	public String updateModelHasPermission(ModelHasPermission modelHasPermission) {
//		return modelHasPermissionRepository.save(modelHasPermission) != null ? " successfully updated!"
//				: "Failed! Please try again!!";
//	}
//
//	public String deleteOneModelHasPermission(ModelHasPermissionPK id) {
//		modelHasPermissionRepository.deleteById(id);
//		return " successfully deleted!";
//	}
//}
