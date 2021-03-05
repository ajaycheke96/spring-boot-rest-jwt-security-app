package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the employee_categories database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_categories")
public class EmployeeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	private String description;

	@Column(length = 20)
	private String name;

	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to CommunicationEmployeeCategory
//	@OneToMany(mappedBy = "employeeCategory")
//	private List<CommunicationEmployeeCategory> communicationEmployeeCategories;

//	// bi-directional many-to-one association to Designation
////	@OneToMany(mappedBy = "employeeCategory")
//	@OneToMany(targetEntity = Designation.class)
//	@JoinColumn(name = "employee_category_id")
//	private List<Designation> designations;

//	// bi-directional many-to-one association to EventEmployeeCategory
//	@OneToMany(mappedBy = "employeeCategory")
//	private List<EventEmployeeCategory> eventEmployeeCategories;

//	// bi-directional many-to-one association to MeetingEmployeeCategory
//	@OneToMany(mappedBy = "employeeCategory")
//	private List<MeetingEmployeeCategory> meetingEmployeeCategories;

}