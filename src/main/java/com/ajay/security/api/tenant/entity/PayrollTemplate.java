package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the payroll_templates database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "payroll_templates")
public class PayrollTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(name = "is_active")
	private byte isActive;

	@Column(length = 30)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

//	// bi-directional many-to-one association to EmployeeSalary
//	@OneToMany(mappedBy = "payrollTemplate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<EmployeeSalary> employeeSalaries;

	// bi-directional many-to-one association to PayrollTemplateDetail
//	@OneToMany(mappedBy = "payrollTemplate", cascade = CascadeType.ALL)
	@OneToMany(targetEntity = PayrollTemplateDetail.class)
	@JoinColumn(name = "payroll_template_id")
	private List<PayrollTemplateDetail> payrollTemplateDetails;

}