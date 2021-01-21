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
//import com.ajay.security.api.tenant.entity.ModelHasPermission;
//import com.ajay.security.api.tenant.entity.ModelHasPermissionPK;
//import com.ajay.security.api.tenant.service.ModelHasPermissionService;
//
//@RestController
//@RequestMapping("/modelHasPermission")
//public class ModelHasPermissionController {
//
//	@Autowired
//	private ModelHasPermissionService modelHasPermissionService;
//
//	@GetMapping("/all")
//	public List<ModelHasPermission> getAllModelHasPermission() {
//		return modelHasPermissionService.getAllModelHasPermissions();
//	}
//
//	@GetMapping("/one/{permissionId}/{modelId}/{modelType}")
//	public ModelHasPermission getOneModelHasPermission(@PathVariable Integer permissionId,
//			@PathVariable Integer modelId, @PathVariable String modelType) {
//		return modelHasPermissionService
//				.getOneModelHasPermission(new ModelHasPermissionPK(permissionId, modelId, modelType));
//	}
//
//	@PostMapping("/save")
//	public String saveModelHasPermission(@RequestBody ModelHasPermission modelHasPermission) {
//		return modelHasPermissionService.saveModelHasPermission(modelHasPermission);
//	}
//
//	@PutMapping("/update")
//	public String updateModelHasPermission(@RequestBody ModelHasPermission modelHasPermission) {
//		return modelHasPermissionService.updateModelHasPermission(modelHasPermission);
//	}
//
//	@DeleteMapping("/delete")
//	public String deleteOneModelHasPermission(@RequestBody ModelHasPermissionPK modelHasPermissionPK) {
//		return modelHasPermissionService.deleteOneModelHasPermission(modelHasPermissionPK);
//	}
//}
