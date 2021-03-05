package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Employee;
import com.ajay.security.api.tenant.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getOneEmployee(Integer id) {
		return employeeRepository.findById(id).get();
	}

	public Employee saveEmployee(Employee employee) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employee.getCreatedAt() == null)
			employee.setCreatedAt(currentTimestamp);
		employee.setUpdatedAt(currentTimestamp);

		/**
		 * TODO: for null value initialize the given value
		 */

//		List<Payroll> payrolls = employee.getPayrolls();
//		if(!payrolls.isEmpty()) {
//			employee.getEmployeeSalaries().forEach(es -> es.setPayrolls(payrolls));
//		}

		return employeeRepository.save(employee);
	}

	public String deleteOneEmployee(Employee employee) {
		String result = null;
		if (employeeRepository.existsById(employee.getId())) {
			employeeRepository.delete(employee);
			result = " Employee deleted!";
		} else {
			result = "Employee Not Found! or Already deleted!";
		}
		return result;
	}
}
