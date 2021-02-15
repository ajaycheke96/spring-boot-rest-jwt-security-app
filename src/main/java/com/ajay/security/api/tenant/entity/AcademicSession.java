package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the academic_sessions database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "academic_sessions")
public class AcademicSession implements Serializable {
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

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "is_default")
	private byte isDefault;

	@Column(length = 20)
	private String name;

	@Lob
	@Column(length = 50)
	private String options;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to ClassTiming
//	@OneToMany(mappedBy = "academicSession")
//	@JsonIgnoreProperties("academicSession")
//	private List<ClassTiming> classTimings;

//	// bi-directional many-to-one association to CourseGroup
//	@OneToMany(mappedBy = "academicSession")
//	private List<CourseGroup> courseGroups;

//	// bi-directional many-to-one association to Cours
//	@OneToMany(mappedBy = "academicSession")
//	private List<Course> courses;

//	// bi-directional many-to-one association to ExamAssessment
//	@OneToMany(mappedBy = "academicSession")
//	private List<ExamAssessment> examAssessments;

//	// bi-directional many-to-one association to ExamGrade
//	@OneToMany(mappedBy = "academicSession")
//	private List<ExamGrade> examGrades;

//	// bi-directional many-to-one association to ExamObservation
//	@OneToMany(mappedBy = "academicSession")
//	private List<ExamObservation> examObservations;

//	// bi-directional many-to-one association to ExamTerm
//	@OneToMany(mappedBy = "academicSession")
//	private List<ExamTerm> examTerms;

//	// bi-directional many-to-one association to Exam
//	@OneToMany(mappedBy = "academicSession")
//	private List<Exam> exams;

//	// bi-directional many-to-one association to FeeConcession
//	@OneToMany(mappedBy = "academicSession")
//	private List<FeeConcession> feeConcessions;

//	// bi-directional many-to-one association to FeeGroup
//	@OneToMany(mappedBy = "academicSession")
//	private List<FeeGroup> feeGroups;

//	// bi-directional many-to-one association to OnlineExam
//	@OneToMany(mappedBy = "academicSession")
//	private List<OnlineExam> onlineExams;

//	// bi-directional many-to-one association to StudentRecord
//	@OneToMany(mappedBy = "academicSession")
//	private List<StudentRecord> studentRecords;

//	// bi-directional many-to-one association to TransportCircle
//	@OneToMany(mappedBy = "academicSession")
//	private List<TransportCircle> transportCircles;

//	// bi-directional many-to-one association to TransportFee
//	@OneToMany(mappedBy = "academicSession")
//	private List<TransportFee> transportFees;

//	// bi-directional many-to-one association to TransportRoute
//	@OneToMany(mappedBy = "academicSession")
//	private List<TransportRoute> transportRoutes;

//	// bi-directional many-to-one association to TransportStoppage
//	@OneToMany(mappedBy = "academicSession")
//	private List<TransportStoppage> transportStoppages;
//
//	// bi-directional many-to-one association to UserPreference
//	@OneToMany(mappedBy = "academicSession")
//	private List<UserPreference> userPreferences;
}