package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the employee_terms database table.
 * 
 */
@Data
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
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_joining")
	private Date dateOfJoining;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_leaving")
	private Date dateOfLeaving;

	@Column(name = "joining_remarks",length = 50)
	private String joiningRemarks;

	@Column(name = "leaving_remarks",length = 50)
	private String leavingRemarks;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to EmployeeDesignation
	@OneToMany(mappedBy = "employeeTerm",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeDesignation> employeeDesignations;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

}