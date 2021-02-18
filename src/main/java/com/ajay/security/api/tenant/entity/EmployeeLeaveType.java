package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the employee_leave_types database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_leave_types")
public class EmployeeLeaveType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 20)
	private String alias;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(name = "is_active")
	private byte isActive;

	@Column(length = 20)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to EmployeeLeaveAllocationDetail
////	@OneToMany(mappedBy = "employeeLeaveType")
//	@OneToMany(targetEntity = EmployeeLeaveAllocationDetail.class)
//	private List<EmployeeLeaveAllocationDetail> employeeLeaveAllocationDetails;

//	// bi-directional many-to-one association to EmployeeLeaveRequest
//	@OneToMany(mappedBy = "employeeLeaveType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private List<EmployeeLeaveRequest> employeeLeaveRequests;

}