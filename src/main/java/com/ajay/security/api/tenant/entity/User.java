package com.ajay.security.api.tenant.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(	name = "users_2")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;

	private String password;
	
	private String email;

	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	
	@Column(name="activation_token")
	private String activationToken;

	@Column(name="created_at")
	private Timestamp createdAt;
	
	private byte enabled;
	
	@Column(name="remember_token")
	private String rememberToken;

	private String status;

	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	private String uuid;

	//bi-directional many-to-one association to AccountTransfer
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<AccountTransfer> accountTransfers;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Article> articles;

	//bi-directional many-to-one association to Backup
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Backup> backups;

	//bi-directional many-to-one association to CallLog
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<CallLog> callLogs;

	//bi-directional many-to-one association to Communication
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Communication> communications;

	//bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Complaint> complaints;

	//bi-directional many-to-one association to EmployeeLeaveRequestDetail
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeLeaveRequestDetail> employeeLeaveRequestDetails;

	//bi-directional many-to-one association to EmployeeLeaveRequest
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeLeaveRequest> employeeLeaveRequests;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Employee> employees;

	//bi-directional many-to-one association to Enquiry
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Enquiry> enquiries;

	//bi-directional many-to-one association to EnquiryFollowUp
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EnquiryFollowUp> enquiryFollowUps;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Event> events;

	//bi-directional many-to-one association to Expens
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Expense> expenses;

	//bi-directional many-to-one association to GatePass
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<GatePass> gatePasses;

	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Income> incomes;

	//bi-directional many-to-one association to Meeting
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Meeting> meetings;

	//bi-directional many-to-one association to PostalRecord
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<PostalRecord> postalRecords;

	//bi-directional many-to-one association to StockPurchas
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StockPurchase> stockPurchases;

	//bi-directional many-to-one association to StockTransferReturn
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StockTransferReturn> stockTransferReturns;

	//bi-directional many-to-one association to StockTransfer
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StockTransfer> stockTransfers;

	//bi-directional many-to-one association to StudentParent
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StudentParent> studentParents;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Student> students;

	//bi-directional many-to-one association to Todo
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Todo> todos;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	//bi-directional many-to-one association to Upload
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Upload> uploads;

	//bi-directional many-to-one association to UserPreference
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<UserPreference> userPreferences;

	//bi-directional many-to-one association to UserPushToken
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<UserPushToken> userPushTokens;
}
