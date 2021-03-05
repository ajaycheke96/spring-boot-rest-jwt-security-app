package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeLeaveRequest;
import com.ajay.security.api.tenant.repository.EmployeeLeaveRequestRepository;

@Service
@Transactional
public class EmployeeLeaveRequestService {

	@Autowired
	private EmployeeLeaveRequestRepository employeeLeaveRequestRepository;

	public List<EmployeeLeaveRequest> getAllEmployeeLeaveRequests() {
		return employeeLeaveRequestRepository.findAll();
	}

	public EmployeeLeaveRequest getOneEmployeeLeaveRequest(Integer id) {
		return employeeLeaveRequestRepository.findById(id).get();
	}

	public EmployeeLeaveRequest saveEmployeeLeaveRequest(EmployeeLeaveRequest employeeLeaveRequest) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employeeLeaveRequest.getCreatedAt() == null)
			employeeLeaveRequest.setCreatedAt(currentTimestamp);
		employeeLeaveRequest.setUpdatedAt(currentTimestamp);

		// For employeeLeaveRequestDetails list
		if (!employeeLeaveRequest.getEmployeeLeaveRequestDetails().isEmpty())
			employeeLeaveRequest.getEmployeeLeaveRequestDetails().forEach(employeeLeaveRequestDetail -> {
				if (employeeLeaveRequestDetail.getCreatedAt() == null)
					employeeLeaveRequestDetail.setCreatedAt(currentTimestamp);
				employeeLeaveRequestDetail.setUpdatedAt(currentTimestamp);
			});
		return employeeLeaveRequestRepository.save(employeeLeaveRequest);
	}

	public String deleteOneEmployeeLeaveRequest(EmployeeLeaveRequest employeeLeaveRequest) {
		String result = null;
		if (employeeLeaveRequestRepository.existsById(employeeLeaveRequest.getId())) {
			employeeLeaveRequestRepository.delete(employeeLeaveRequest);
			result = " EmployeeLeaveRequest deleted!";
		} else {
			result = "EmployeeLeaveRequest Not Found! or Already deleted!";
		}
		return result;
	}
}
