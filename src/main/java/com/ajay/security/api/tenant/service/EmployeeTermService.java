package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeTerm;
import com.ajay.security.api.tenant.repository.EmployeeTermRepository;

@Service
@Transactional
public class EmployeeTermService {

	@Autowired
	private EmployeeTermRepository employeeTermRepository;

	public List<EmployeeTerm> getAllEmployeeTerms() {
		return employeeTermRepository.findAll();
	}

	public EmployeeTerm getOneEmployeeTerm(Integer id) {
		return employeeTermRepository.findById(id).get();
	}

	public EmployeeTerm saveEmployeeTerm(EmployeeTerm employeeTerm) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employeeTerm.getCreatedAt() == null)
			employeeTerm.setCreatedAt(currentTimestamp);
		employeeTerm.setUpdatedAt(currentTimestamp);
		return employeeTermRepository.save(employeeTerm);
	}

	public String deleteOneEmployeeTerm(EmployeeTerm employeeTerm) {
		String result = null;
		if (employeeTermRepository.existsById(employeeTerm.getId())) {
			employeeTermRepository.delete(employeeTerm);
			result = " EmployeeTerm deleted!";
		} else {
			result = "EmployeeTerm Not Found! or Already deleted!";
		}
		return result;
	}
}
