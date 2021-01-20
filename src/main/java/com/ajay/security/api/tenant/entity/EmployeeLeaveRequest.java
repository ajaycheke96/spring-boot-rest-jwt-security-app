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
 * The persistent class for the employee_leave_requests database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_leave_requests")
public class EmployeeLeaveRequest implements Serializable {
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

	@Column(length = 50)
	private String reason;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Column(length = 20)
	private String status;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(length = 20)
	private String uuid;

	// bi-directional many-to-one association to EmployeeLeaveRequestDetail
	@OneToMany(mappedBy = "employeeLeaveRequest",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeLeaveRequestDetail> employeeLeaveRequestDetails;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional many-to-one association to EmployeeLeaveType
	@ManyToOne
	@JoinColumn(name = "employee_leave_type_id")
	private EmployeeLeaveType employeeLeaveType;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "requester_user_id")
	private User user;

}