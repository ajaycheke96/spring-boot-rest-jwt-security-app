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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the employees database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "alternate_contact_number")
	private String alternateContactNumber;

	@Column(name = "alternate_email")
	private String alternateEmail;

	private int code;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_anniversary")
	private Date dateOfAnniversary;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	private String email;

	@Column(name = "emergency_contact_name")
	private String emergencyContactName;

	@Column(name = "emergency_contact_number")
	private String emergencyContactNumber;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "first_name")
	private String firstName;

	private String gender;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "mother_tongue")
	private String motherTongue;

	private String nationality;

	@Lob
	private String options;

	@Column(name = "permanent_address_line_1")
	private String permanentAddressLine1;

	@Column(name = "permanent_address_line_2")
	private String permanentAddressLine2;

	@Column(name = "permanent_city")
	private String permanentCity;

	@Column(name = "permanent_country")
	private String permanentCountry;

	@Column(name = "permanent_state")
	private String permanentState;

	@Column(name = "permanent_zipcode")
	private String permanentZipcode;

	private String photo;

	private String prefix;

	@Column(name = "present_address_line_1")
	private String presentAddressLine1;

	@Column(name = "present_address_line_2")
	private String presentAddressLine2;

	@Column(name = "present_city")
	private String presentCity;

	@Column(name = "present_country")
	private String presentCountry;

	@Column(name = "present_state")
	private String presentState;

	@Column(name = "present_zipcode")
	private String presentZipcode;

	@Column(name = "same_as_present_address")
	private byte sameAsPresentAddress;

	@Column(name = "spouse_name")
	private String spouseName;

	@Column(name = "unique_identification_number")
	private String uniqueIdentificationNumber;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	private String uuid;

//	// bi-directional many-to-one association to Assignment
//	@OneToMany(mappedBy = "employee")
//	private List<Assignment> assignments;

//	// bi-directional many-to-one association to Bill
//	@OneToMany(mappedBy = "employee")
//	@JsonIgnoreProperties("employee")
//	private List<Bill> bills;

	// bi-directional many-to-one association to BookLog
	@OneToMany(mappedBy = "employee")
	private List<BookLog> bookLogs;

	// bi-directional many-to-one association to Certificate
	@OneToMany(mappedBy = "employee")
	private List<Certificate> certificates;

//	// bi-directional many-to-one association to ClassTeacher
//	@OneToMany(mappedBy = "employee")
//	private List<ClassTeacher> classTeachers;

	// bi-directional many-to-one association to CommunicationEmployee
	@OneToMany(mappedBy = "employee")
	private List<CommunicationEmployee> communicationEmployees;

	// bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy = "employee")
	private List<Complaint> complaints;

	// bi-directional many-to-one association to EmployeeAccount
	@OneToMany(mappedBy = "employee")
	private List<EmployeeAccount> employeeAccounts;

	// bi-directional many-to-one association to EmployeeAttendance
	@OneToMany(mappedBy = "employee")
	private List<EmployeeAttendance> employeeAttendances;

	// bi-directional many-to-one association to EmployeeDesignation
	@OneToMany(mappedBy = "employee")
	private List<EmployeeDesignation> employeeDesignations;

	// bi-directional many-to-one association to EmployeeDocument
	@OneToMany(mappedBy = "employee")
	private List<EmployeeDocument> employeeDocuments;

	// bi-directional many-to-one association to EmployeeGroupCollection
	@OneToMany(mappedBy = "employee")
	private List<EmployeeGroupCollection> employeeGroupCollections;

//	// bi-directional many-to-one association to EmployeeLeaveAllocation
//	@OneToMany(mappedBy = "employee")
//	private List<EmployeeLeaveAllocation> employeeLeaveAllocations;

//	// bi-directional many-to-one association to EmployeeLeaveRequest
//	@OneToMany(mappedBy = "employee")
//	private List<EmployeeLeaveRequest> employeeLeaveRequests;

	// bi-directional many-to-one association to EmployeeQualification
	@OneToMany(mappedBy = "employee")
	private List<EmployeeQualification> employeeQualifications;

	// bi-directional many-to-one association to EmployeeSalary
//	@OneToMany(mappedBy = "employee")
	@OneToMany(targetEntity = EmployeeSalary.class)
	@JoinColumn(name = "employee_id")
	private List<EmployeeSalary> employeeSalaries;

//	// bi-directional many-to-one association to EmployeeTerm
////	@OneToMany(mappedBy = "employee")
//	@OneToMany(targetEntity = EmployeeTerm.class)
//	@JoinColumn(name = "employee_id")
//	private List<EmployeeTerm> employeeTerms;

	// bi-directional many-to-one association to BloodGroup
	@ManyToOne(targetEntity = BloodGroup.class)
	@JoinColumn(name = "blood_group_id")
	private BloodGroup bloodGroup;

	// bi-directional many-to-one association to Caste
	@ManyToOne(targetEntity = Caste.class)
	@JoinColumn(name = "caste_id")
	private Caste caste;

	// bi-directional many-to-one association to Category
	@ManyToOne(targetEntity = Category.class)
	@JoinColumn(name = "category_id")
	private Category category;

	// bi-directional many-to-one association to Religion
	@ManyToOne(targetEntity = Religion.class)
	@JoinColumn(name = "religion_id")
	private Religion religion;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties({ "userPushTokens", "userPreferences", "uploads", "todos", "postalRecords", "backups",
			"password" })
	private User user;

//	// bi-directional many-to-one association to Expens
//	@OneToMany(mappedBy = "employee")
//	private List<Expense> expenses;

//	// bi-directional many-to-one association to GatePass
//	@OneToMany(mappedBy = "employee")
//	private List<GatePass> gatePasses;

	// bi-directional many-to-one association to Income
//	@OneToMany(mappedBy = "employee")
	@OneToMany(targetEntity = Income.class)
	@JoinColumn(name = "employee_id")
	private List<Income> incomes;

//	// bi-directional many-to-one association to LessonPlan
//	@OneToMany(mappedBy = "employee")
//	private List<LessonPlan> lessonPlans;

	// bi-directional many-to-one association to MeetingEmployee
	@OneToMany(mappedBy = "employee")
	private List<MeetingEmployee> meetingEmployees;

//	// bi-directional many-to-one association to Note
//	@OneToMany(mappedBy = "employee")
//	private List<Note> notes;

	// bi-directional many-to-one association to Payroll
//	@OneToMany(mappedBy = "employee")
	@OneToMany(targetEntity = Payroll.class)
	@JoinColumn(name = "employee_id")
	private List<Payroll> payrolls;

//	// bi-directional many-to-one association to StockTransfer
//	@OneToMany(mappedBy = "employee")
//	@JsonIgnoreProperties("employee")
//	private List<StockTransfer> stockTransfers;

//	// bi-directional many-to-one association to SubjectTeacher
//	@OneToMany(mappedBy = "employee")
//	private List<SubjectTeacher> subjectTeachers;

//	// bi-directional many-to-one association to Syllabus
//	@OneToMany(mappedBy = "employee")
//	private List<Syllabus> syllabuses;

//	// bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy = "employee")
//	private List<Transaction> transactions;

	// bi-directional many-to-one association to VehicleIncharge
	@OneToMany(mappedBy = "employee")
	@JsonIgnoreProperties("employee")
	private List<VehicleIncharge> vehicleIncharges;

	// bi-directional many-to-one association to VehicleServiceRecord
	@OneToMany(mappedBy = "employee")
	@JsonIgnoreProperties("employee")
	private List<VehicleServiceRecord> vehicleServiceRecords;

	// bi-directional many-to-one association to VisitorLog
	@OneToMany(mappedBy = "employee")
	private List<VisitorLog> visitorLogs;

}