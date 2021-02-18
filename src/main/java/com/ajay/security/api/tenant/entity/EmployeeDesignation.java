package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the employee_designations database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_designations")
public class EmployeeDesignation implements Serializable {
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

	@Temporal(TemporalType.DATE)
	@Column(name = "date_end")
	private Date dateEnd;

	@Lob
	private String options;

	@Lob
	private String remarks;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to Department
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "department_id")
	private Department department;

	// bi-directional many-to-one association to Designation
	@ManyToOne(targetEntity = Designation.class)
	@JoinColumn(name = "designation_id")
	private Designation designation;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

//	// bi-directional many-to-one association to EmployeeTerm
//	@ManyToOne
//	@JoinColumn(name = "employee_term_id")
//	private EmployeeTerm employeeTerm;

}