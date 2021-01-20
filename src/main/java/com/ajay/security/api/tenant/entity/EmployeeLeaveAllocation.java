package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the employee_leave_allocations database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_leave_allocations")
public class EmployeeLeaveAllocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Column(length = 50)
	private String options;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(length = 20)
	private String uuid;

	// bi-directional many-to-one association to EmployeeLeaveAllocationDetail
	@OneToMany(mappedBy = "employeeLeaveAllocation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EmployeeLeaveAllocationDetail> employeeLeaveAllocationDetails;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

}