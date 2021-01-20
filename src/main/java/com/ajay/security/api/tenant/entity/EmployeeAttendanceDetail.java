package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the employee_attendance_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_attendance_details")
public class EmployeeAttendanceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String options;

	@Lob
	private String remarks;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	private BigDecimal value;

	// bi-directional many-to-one association to EmployeeAttendance
	@ManyToOne
	@JoinColumn(name = "employee_attendance_id")
	private EmployeeAttendance employeeAttendance;

	// bi-directional many-to-one association to EmployeeAttendanceType
	@ManyToOne
	@JoinColumn(name = "employee_attendance_type_id")
	private EmployeeAttendanceType employeeAttendanceType;

}