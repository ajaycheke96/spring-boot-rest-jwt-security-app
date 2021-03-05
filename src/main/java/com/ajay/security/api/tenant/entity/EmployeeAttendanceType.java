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
 * The persistent class for the employee_attendance_types database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	private String description;

	@Column(name = "is_active")
	private byte isActive;

	private String name;

	private String options;

	private String type;

	private String unit;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to EmployeeAttendanceDetail
//	@OneToMany(mappedBy = "employeeAttendanceType")
//	private List<EmployeeAttendanceDetail> employeeAttendanceDetails;

//	// bi-directional many-to-one association to EmployeeAttendance
//	@OneToMany(mappedBy = "employeeAttendanceType")
//	private List<EmployeeAttendance> employeeAttendances;

//	// bi-directional many-to-one association to PayrollTemplateDetail
//	@OneToMany(mappedBy = "employeeAttendanceType")
//	private List<PayrollTemplateDetail> payrollTemplateDetails;

}