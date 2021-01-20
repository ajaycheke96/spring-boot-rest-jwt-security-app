package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.EmployeeLeaveAllocationDetail;

@Repository
public interface EmployeeLeaveAllocationDetailRepository extends JpaRepository<EmployeeLeaveAllocationDetail, Integer> {

}
