package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the employee_attendance_types database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_attendance_types")
public class EmployeeAttendanceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	private String alias;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String description;

	@Column(name = "is_active")
	private byte isActive;

	private String name;

	@Lob
	private String options;

	private String type;

	private String unit;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to EmployeeAttendanceDetail
	@OneToMany(mappedBy = "employeeAttendanceType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeAttendanceDetail> employeeAttendanceDetails;

	// bi-directional many-to-one association to EmployeeAttendance
	@OneToMany(mappedBy = "employeeAttendanceType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeAttendance> employeeAttendances;

	// bi-directional many-to-one association to PayrollTemplateDetail
	@OneToMany(mappedBy = "employeeAttendanceType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<PayrollTemplateDetail> payrollTemplateDetails;

}