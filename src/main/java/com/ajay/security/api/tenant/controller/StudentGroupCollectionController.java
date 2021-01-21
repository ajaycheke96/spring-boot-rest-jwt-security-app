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

import com.ajay.security.api.tenant.entity.StudentGroupCollection;
import com.ajay.security.api.tenant.service.StudentGroupCollectionService;

@RestController
@RequestMapping("/studentGroupCollection")
public class StudentGroupCollectionController {

	@Autowired
	private StudentGroupCollectionService studentGroupCollectionService;

	@GetMapping("/all")
	public List<StudentGroupCollection> getAllStudentGroupCollection() {
		return studentGroupCollectionService.getAllStudentGroupCollections();
	}

	@GetMapping("/one/{id}")
	public StudentGroupCollection getOneStudentGroupCollection(@PathVariable Integer id) {
		return studentGroupCollectionService.getOneStudentGroupCollection(id);
	}

	@PostMapping("/save")
	public String saveStudentGroupCollection(@RequestBody StudentGroupCollection studentGroupCollection) {
		return studentGroupCollectionService.saveStudentGroupCollection(studentGroupCollection);
	}

	@PutMapping("/update")
	public String updateStudentGroupCollection(@RequestBody StudentGroupCollection studentGroupCollection) {
		return studentGroupCollectionService.updateStudentGroupCollection(studentGroupCollection);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStudentGroupCollection(@PathVariable Integer id) {
		return studentGroupCollectionService.deleteOneStudentGroupCollection(id);
	}
}
