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
 * The persistent class for the courses database table.
 * 
 */
@Data
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
	private Timestamp createdAt;

	@Lob
	@Column(length = 50)
	private String description;

	@Column(length = 20)
	private String name;

	@Lob
	@Column(length = 50)
	private String options;

	private int position;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Batch
	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Batch> batches;

	// bi-directional many-to-one association to CommunicationCourse
	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<CommunicationCourse> communicationCourses;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne
	@JoinColumn(name = "academic_session_id")
	private AcademicSession academicSession;

	// bi-directional many-to-one association to CourseGroup
	@ManyToOne
	@JoinColumn(name = "course_group_id")
	private CourseGroup courseGroup;

	// bi-directional many-to-one association to EnquiryDetail
	@OneToMany(mappedBy = "cours",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EnquiryDetail> enquiryDetails;

	// bi-directional many-to-one association to EventCourse
	@OneToMany(mappedBy = "cours",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EventCourse> eventCourses;

	// bi-directional many-to-one association to FeeAllocation
	@OneToMany(mappedBy = "cours",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<FeeAllocation> feeAllocations;

	// bi-directional many-to-one association to MeetingCourse
	@OneToMany(mappedBy = "cours",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<MeetingCourse> meetingCourses;

	// bi-directional many-to-one association to Registration
	@OneToMany(mappedBy = "cours",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Registration> registrations;

}