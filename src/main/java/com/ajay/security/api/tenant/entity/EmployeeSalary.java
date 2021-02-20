package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the employee_salaries database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_salaries")
public class EmployeeSalary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_effective")
	private Date dateEffective;

	@Column(length = 50)
	private String description;

	@Column(name = "net_salary")
	private BigDecimal netSalary;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 20)
	private String uuid;

//	// bi-directional many-to-one association to Employee
//	@ManyToOne
//	private Employee employee;

	// bi-directional many-to-one association to PayrollTemplate
	@ManyToOne(targetEntity = PayrollTemplate.class)
	@JoinColumn(name = "payroll_template_id")
	private PayrollTemplate payrollTemplate;

	// bi-directional many-to-one association to EmployeeSalaryDetail
//	@OneToMany(mappedBy = "employeeSalary",cascade = CascadeType.ALL)
	@OneToMany(targetEntity = EmployeeSalaryDetail.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_salary_id")
	private List<EmployeeSalaryDetail> employeeSalaryDetails;

	// bi-directional many-to-one association to Payroll
//	@OneToMany(mappedBy = "employeeSalary")
	@OneToMany(targetEntity = Payroll.class)
	@JoinColumn(name = "employee_salary_id")
	private List<Payroll> payrolls;

}