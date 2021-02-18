package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the courses database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "courses")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(length = 20)
	private String name;

	@Column(length = 50)
	private String options;

	private int position;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to Batch
//	@OneToMany(mappedBy = "course")
//	private List<Batch> batches;

//	// bi-directional many-to-one association to CommunicationCourse
//	@OneToMany(mappedBy = "course")
//	private List<CommunicationCourse> communicationCourses;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne(targetEntity = AcademicSession.class)
	@JoinColumn(name = "academic_session_id")
	private AcademicSession academicSession;

	// bi-directional many-to-one association to CourseGroup
	@ManyToOne(targetEntity = CourseGroup.class)
	@JoinColumn(name = "course_group_id")
	private CourseGroup courseGroup;

//	// bi-directional many-to-one association to EnquiryDetail
//	@OneToMany(mappedBy = "cours")
//	private List<EnquiryDetail> enquiryDetails;

//	// bi-directional many-to-one association to EventCourse
//	@OneToMany(mappedBy = "cours")
//	@JsonIgnoreProperties("cours")
//	private List<EventCourse> eventCourses;

//	// bi-directional many-to-one association to FeeAllocation
//	@OneToMany(mappedBy = "cours")
//	private List<FeeAllocation> feeAllocations;

//	// bi-directional many-to-one association to MeetingCourse
//	@OneToMany(mappedBy = "cours")
//	private List<MeetingCourse> meetingCourses;

//	// bi-directional many-to-one association to Registration
//	@OneToMany(mappedBy = "cours")
//	private List<Registration> registrations;

}