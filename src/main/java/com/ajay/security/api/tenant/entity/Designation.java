package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the designations database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Lob
	private String description;

	@Column(name = "is_teaching_employee")
	private byte isTeachingEmployee;

	private String name;

	@Lob
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to EmployeeCategory
	@ManyToOne
	@JoinColumn(name = "employee_category_id")
	private EmployeeCategory employeeCategory;

	// bi-directional many-to-one association to Designation
	@ManyToOne(targetEntity = Designation.class)
	@JoinColumn(name = "top_designation_id")
	private Designation designation;

//	// bi-directional many-to-one association to EmployeeDesignation
//	@OneToMany(mappedBy = "designation")
//	private List<EmployeeDesignation> employeeDesignations;

//	// bi-directional many-to-one association to EmployeeLeaveRequestDetail
//	@OneToMany(mappedBy = "designation")
//	private List<EmployeeLeaveRequestDetail> employeeLeaveRequestDetails;

}