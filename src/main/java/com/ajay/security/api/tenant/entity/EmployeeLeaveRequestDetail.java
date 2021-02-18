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
 * The persistent class for the employee_leave_request_details database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_leave_request_details")
public class EmployeeLeaveRequestDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	private String comment;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_action")
	private Date dateOfAction;

	private String options;

	private String status;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "approver_user_id")
	private User user;

	// bi-directional many-to-one association to Designation
	@ManyToOne(targetEntity = Designation.class)
	@JoinColumn(name = "designation_id")
	private Designation designation;

//	// bi-directional many-to-one association to EmployeeLeaveRequest
//	@ManyToOne
//	@JoinColumn(name = "employee_leave_request_id")
//	private EmployeeLeaveRequest employeeLeaveRequest;

}