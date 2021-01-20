package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeSalaryDetail;
import com.ajay.security.api.tenant.repository.EmployeeSalaryDetailRepository;

@Service
@Transactional
public class EmployeeSalaryDetailService {

	@Autowired
	private EmployeeSalaryDetailRepository employeeSalaryDetailRepository;

	public List<EmployeeSalaryDetail> getAllEmployeeSalaryDetails() {
		return employeeSalaryDetailRepository.findAll();
	}

	public EmployeeSalaryDetail getOneEmployeeSalaryDetail(Integer id) {
		return employeeSalaryDetailRepository.findById(id).get();
	}

	public String saveEmployeeSalaryDetail(EmployeeSalaryDetail employeeSalaryDetail) {
		return employeeSalaryDetailRepository.save(employeeSalaryDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeSalaryDetail(EmployeeSalaryDetail employeeSalaryDetail) {
		return employeeSalaryDetailRepository.save(employeeSalaryDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeSalaryDetail(Integer id) {
		employeeSalaryDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
