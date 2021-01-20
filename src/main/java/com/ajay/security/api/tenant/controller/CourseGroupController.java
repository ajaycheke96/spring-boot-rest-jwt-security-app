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

import com.ajay.security.api.tenant.entity.CourseGroup;
import com.ajay.security.api.tenant.service.CourseGroupService;

@RestController
@RequestMapping("/courseGroup")
public class CourseGroupController {

	@Autowired
	private CourseGroupService courseGroupService;

	@GetMapping("/all")
	public List<CourseGroup> getAllCourseGroup() {
		return courseGroupService.getAllCourseGroups();
	}

	@GetMapping("/one/{id}")
	public CourseGroup getOneCourseGroup(@PathVariable Integer id) {
		return courseGroupService.getOneCourseGroup(id);
	}

	@PostMapping("/save")
	public String saveCourseGroup(@RequestBody CourseGroup courseGroup) {
		return courseGroupService.saveCourseGroup(courseGroup);
	}

	@PutMapping("/update")
	public String updateCourseGroup(@RequestBody CourseGroup courseGroup) {
		return courseGroupService.updateCourseGroup(courseGroup);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCourseGroup(@PathVariable Integer id) {
		return courseGroupService.deleteOneCourseGroup(id);
	}
}
