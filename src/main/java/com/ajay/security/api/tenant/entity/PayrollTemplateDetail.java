package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the payroll_template_details database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "payroll_template_details")
public class PayrollTemplateDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 50)
	private String category;

	@Column(length = 50)
	private String computation;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String options;

	@Column(length = 10)
	private int position;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to EmployeeSalaryDetail
//	@OneToMany(mappedBy = "payrollTemplateDetail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<EmployeeSalaryDetail> employeeSalaryDetails;

	// bi-directional many-to-one association to EmployeeAttendanceType
	@ManyToOne(targetEntity = EmployeeAttendanceType.class)
	@JoinColumn(name = "employee_attendance_type_id")
	private EmployeeAttendanceType employeeAttendanceType;

	// bi-directional many-to-one association to PayHead
	@ManyToOne(targetEntity = PayHead.class)
	@JoinColumn(name = "pay_head_id")
	private PayHead payHead;

//	// bi-directional many-to-one association to PayrollTemplate
//	@ManyToOne
//	@JoinColumn(name = "payroll_template_id")
//	private PayrollTemplate payrollTemplate;

}