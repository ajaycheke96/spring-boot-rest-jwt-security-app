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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the designations database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "designations")
public class Designation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String description;

	@Column(name = "is_teaching_employee")
	private byte isTeachingEmployee;

	private String name;

	@Lob
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to EmployeeCategory
	@ManyToOne
	@JoinColumn(name = "employee_category_id")
	private EmployeeCategory employeeCategory;

	// bi-directional many-to-one association to Designation
	@ManyToOne
	@JoinColumn(name = "top_designation_id")
	private Designation designation;

	// bi-directional many-to-one association to Designation
	@OneToMany(mappedBy = "designation",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Designation> designations;

	// bi-directional many-to-one association to EmployeeDesignation
	@OneToMany(mappedBy = "designation",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeDesignation> employeeDesignations;

	// bi-directional many-to-one association to EmployeeLeaveRequestDetail
	@OneToMany(mappedBy = "designation",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeLeaveRequestDetail> employeeLeaveRequestDetails;

}