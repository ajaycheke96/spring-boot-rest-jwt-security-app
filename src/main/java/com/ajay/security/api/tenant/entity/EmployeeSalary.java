package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the employee_salaries database table.
 * 
 */
@Data
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
	private Timestamp updatedAt;

	@Column(length = 20)
	private String uuid;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional many-to-one association to PayrollTemplate
	@ManyToOne
	@JoinColumn(name = "payroll_template_id")
	private PayrollTemplate payrollTemplate;

	// bi-directional many-to-one association to EmployeeSalaryDetail
	@OneToMany(mappedBy = "employeeSalary",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeSalaryDetail> employeeSalaryDetails;

	// bi-directional many-to-one association to Payroll
	@OneToMany(mappedBy = "employeeSalary",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Payroll> payrolls;

}