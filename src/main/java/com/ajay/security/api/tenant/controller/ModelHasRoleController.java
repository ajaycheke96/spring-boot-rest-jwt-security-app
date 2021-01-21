//package com.ajay.security.api.tenant.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ajay.security.api.tenant.entity.ModelHasRole;
//import com.ajay.security.api.tenant.entity.ModelHasRolePK;
//import com.ajay.security.api.tenant.service.ModelHasRoleService;
//
//@RestController
//@RequestMapping("/modelHasRole")
//public class ModelHasRoleController {
//
//	@Autowired
//	private ModelHasRoleService modelHasRoleService;
//
//	@GetMapping("/all")
//	public List<ModelHasRole> getAllModelHasRole() {
//		return modelHasRoleService.getAllModelHasRoles();
//	}
//
//	@GetMapping("/one/{roleId}/{modelId}/{modelType}")
//	public ModelHasRole getOneModelHasRole(@PathVariable Integer roleId, @PathVariable Integer modelId,
//			@PathVariable String modelType) {
//		return modelHasRoleService.getOneModelHasRole(new ModelHasRolePK(roleId, modelId, modelType));
//	}
//
//	@PostMapping("/save")
//	public String saveModelHasRole(@RequestBody ModelHasRole modelHasRole) {
//		return modelHasRoleService.saveModelHasRole(modelHasRole);
//	}
//
//	@PutMapping("/update")
//	public String updateModelHasRole(@RequestBody ModelHasRole modelHasRole) {
//		return modelHasRoleService.updateModelHasRole(modelHasRole);
//	}
//
//	@DeleteMapping("/delete")
//	public String deleteOneModelHasRole(@RequestBody ModelHasRolePK modelHasRolePK) {
//		return modelHasRoleService.deleteOneModelHasRole(modelHasRolePK);
//	}
//}
