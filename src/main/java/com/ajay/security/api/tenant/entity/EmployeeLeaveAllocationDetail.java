package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the employee_leave_allocation_details database
 * table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_leave_allocation_details")
public class EmployeeLeaveAllocationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	private int allotted;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	private int used;

	// bi-directional many-to-one association to EmployeeLeaveAllocation
	@ManyToOne
	@JoinColumn(name = "employee_leave_allocation_id")
	private EmployeeLeaveAllocation employeeLeaveAllocation;

	// bi-directional many-to-one association to EmployeeLeaveType
	@ManyToOne
	@JoinColumn(name = "employee_leave_type_id")
	private EmployeeLeaveType employeeLeaveType;

}