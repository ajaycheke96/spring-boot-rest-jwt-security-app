package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.CourseGroup;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.CourseGroupService;

@RestController
@RequestMapping("/courseGroup")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseGroupController {

	@Autowired
	private CourseGroupService courseGroupService;

	@RequestMapping("/listAllCourseGroup")
	public ApiResponse getAllCourseGroup() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "List of CourseGroup",
					courseGroupService.getAllCourseGroups());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CourseGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping("/{id}")
	public ApiResponse getOneCourseGroup(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "CourseGroup",
					courseGroupService.getOneCourseGroup(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CourseGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveCourseGroup", method = RequestMethod.POST)
	public ApiResponse saveCourseGroup(@RequestBody CourseGroup courseGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "CourseGroup saved!",
					courseGroupService.saveCourseGroup(courseGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CourseGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateCourseGroup", method = RequestMethod.POST)
	public ApiResponse updateCourseGroup(@RequestBody CourseGroup courseGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "CourseGroup updated!",
					courseGroupService.saveCourseGroup(courseGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CourseGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteCourseGroup", method = RequestMethod.POST)
	public ApiResponse deleteOneCourseGroup(@RequestBody CourseGroup courseGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					courseGroupService.deleteOneCourseGroup(courseGroup), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"CourseGroup Service exception : " + e.getLocalizedMessage());
		}
	}
}
