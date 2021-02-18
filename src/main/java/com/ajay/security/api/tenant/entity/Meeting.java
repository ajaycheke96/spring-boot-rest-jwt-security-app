package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Time;
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the meetings database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "meetings")
public class Meeting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 50)
	private String audience;

	@Column(length = 100)
	private String code;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(length = 50)
	private String description;

	@Column(name = "end_time")
	private Time endTime;

	@Column(length = 50)
	private String options;

	@Column(name = "start_time")
	private Time startTime;

	@Column(length = 50)
	private String title;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

//	// bi-directional many-to-one association to MeetingBatch
//	@OneToMany(mappedBy = "meeting")
//	private List<MeetingBatch> meetingBatches;

	// bi-directional many-to-one association to MeetingCourse
	@OneToMany(mappedBy = "meeting")
	private List<MeetingCourse> meetingCourses;

	// bi-directional many-to-one association to MeetingDepartment
//	@OneToMany(mappedBy = "meeting")
	@OneToMany(targetEntity = MeetingDepartment.class)
	@JoinColumn(name = "meeting_id")
	private List<MeetingDepartment> meetingDepartments;

	// bi-directional many-to-one association to MeetingEmployee
	@OneToMany(mappedBy = "meeting")
	private List<MeetingEmployee> meetingEmployees;

	// bi-directional many-to-one association to MeetingEmployeeCategory
	@OneToMany(mappedBy = "meeting")
	private List<MeetingEmployeeCategory> meetingEmployeeCategories;

	// bi-directional many-to-one association to MeetingStudentRecord
	@OneToMany(mappedBy = "meeting")
	private List<MeetingStudentRecord> meetingStudentRecords;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

}