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
 * The persistent class for the payrolls database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "payrolls")
public class Payroll implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Column(length = 50)
	private String options;

	private BigDecimal paid;

	@Column(name = "payment_status", length = 20)
	private String paymentStatus;

	@Column(name = "per_day_calculation_basis", length = 20)
	private String perDayCalculationBasis;

	@Column(length = 50)
	private String period;

	@Column(name = "period_detail", length = 50)
	private String periodDetail;

	@Column(length = 50)
	private String remarks;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	private BigDecimal total;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "user_defined_days")
	private int userDefinedDays;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to PayrollDetail
	@OneToMany(mappedBy = "payroll", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PayrollDetail> payrollDetails;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional many-to-one association to EmployeeSalary
	@ManyToOne
	@JoinColumn(name = "employee_salary_id")
	private EmployeeSalary employeeSalary;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "payroll", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Transaction> transactions;

}