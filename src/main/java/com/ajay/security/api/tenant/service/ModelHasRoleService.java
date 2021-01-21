//package com.ajay.security.api.tenant.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ajay.security.api.tenant.entity.ModelHasRole;
//import com.ajay.security.api.tenant.entity.ModelHasRolePK;
//import com.ajay.security.api.tenant.repository.ModelHasRoleRepository;
//
//@Service
//@Transactional
//public class ModelHasRoleService {
//
//	@Autowired
//	private ModelHasRoleRepository modelHasRoleRepository;
//
//	public List<ModelHasRole> getAllModelHasRoles() {
//		return modelHasRoleRepository.findAll();
//	}
//
//	public ModelHasRole getOneModelHasRole(ModelHasRolePK id) {
//		return modelHasRoleRepository.findById(id).get();
//	}
//
//	public String saveModelHasRole(ModelHasRole modelHasRole) {
//		return modelHasRoleRepository.save(modelHasRole) != null ? " successfully saved!"
//				: "Failed! Please try again!!";
//	}
//
//	public String updateModelHasRole(ModelHasRole modelHasRole) {
//		return modelHasRoleRepository.save(modelHasRole) != null ? " successfully updated!"
//				: "Failed! Please try again!!";
//	}
//
//	public String deleteOneModelHasRole(ModelHasRolePK id) {
//		modelHasRoleRepository.deleteById(id);
//		return " successfully deleted!";
//	}
//}
