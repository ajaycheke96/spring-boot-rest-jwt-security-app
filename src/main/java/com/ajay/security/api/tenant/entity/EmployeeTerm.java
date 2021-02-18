package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
 * The persistent class for the employee_terms database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_terms")
public class EmployeeTerm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_joining")
	private Date dateOfJoining;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_leaving")
	private Date dateOfLeaving;

	@Column(name = "joining_remarks", length = 50)
	private String joiningRemarks;

	@Column(name = "leaving_remarks", length = 50)
	private String leavingRemarks;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to EmployeeDesignation
//	@OneToMany(mappedBy = "employeeTerm")
	@OneToMany(targetEntity = EmployeeDesignation.class)
	@JoinColumn(name = "employee_term_id")
	private List<EmployeeDesignation> employeeDesignations;

	// bi-directional many-to-one association to Employee
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "employee_id")
	private Employee employee;

}