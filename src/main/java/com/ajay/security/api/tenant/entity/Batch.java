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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the batches database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "batches")
public class Batch implements Serializable {
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
	@Column(length = 30)
	private String options;

	private int position;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Admission
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Admission> admissions;

	// bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	// bi-directional many-to-one association to ExamGrade
	@ManyToOne
	@JoinColumn(name = "exam_grade_id")
	private ExamGrade examGrade;

	// bi-directional many-to-one association to ExamObservation
	@ManyToOne
	@JoinColumn(name = "exam_observation_id")
	private ExamObservation examObservation;

	// bi-directional many-to-one association to ClassTeacher
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<ClassTeacher> classTeachers;

	// bi-directional many-to-one association to CommunicationBatch
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<CommunicationBatch> communicationBatches;

	// bi-directional many-to-one association to EventBatch
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EventBatch> eventBatches;

	// bi-directional many-to-one association to ExamSchedule
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<ExamSchedule> examSchedules;

	// bi-directional many-to-one association to FeeAllocation
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<FeeAllocation> feeAllocations;

	// bi-directional many-to-one association to MeetingBatch
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<MeetingBatch> meetingBatches;

	// bi-directional many-to-one association to OnlineExam
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OnlineExam> onlineExams;

	// bi-directional many-to-one association to StudentAttendance
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StudentAttendance> studentAttendances;

	// bi-directional many-to-one association to StudentRecord
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StudentRecord> studentRecords;

	// bi-directional many-to-one association to Subject
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Subject> subjects;

	// bi-directional many-to-one association to Timetable
	@OneToMany(mappedBy = "batch",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Timetable> timetables;

}