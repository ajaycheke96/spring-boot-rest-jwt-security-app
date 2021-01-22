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

import com.ajay.security.api.tenant.entity.TransportRouteStudent;
import com.ajay.security.api.tenant.service.TransportRouteStudentService;

@RestController
@RequestMapping("/transportRouteStudent")
public class TransportRouteStudentController {

	@Autowired
	private TransportRouteStudentService transportRouteStudentService;

	@GetMapping("/all")
	public List<TransportRouteStudent> getAllTransportRouteStudent() {
		return transportRouteStudentService.getAllTransportRouteStudents();
	}

	@GetMapping("/one/{id}")
	public TransportRouteStudent getOneTransportRouteStudent(@PathVariable Integer id) {
		return transportRouteStudentService.getOneTransportRouteStudent(id);
	}

	@PostMapping("/save")
	public String saveTransportRouteStudent(@RequestBody TransportRouteStudent transportRouteStudent) {
		return transportRouteStudentService.saveTransportRouteStudent(transportRouteStudent);
	}

	@PutMapping("/update")
	public String updateTransportRouteStudent(@RequestBody TransportRouteStudent transportRouteStudent) {
		return transportRouteStudentService.updateTransportRouteStudent(transportRouteStudent);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransportRouteStudent(@PathVariable Integer id) {
		return transportRouteStudentService.deleteOneTransportRouteStudent(id);
	}
}
