package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the subjects database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "subjects")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String code;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String description;

	@Column(name = "has_no_exam")
	private byte hasNoExam;

	@Column(name = "is_elective")
	private byte isElective;

	@Column(name = "max_class_per_week")
	private int maxClassPerWeek;

	private String name;

	@Lob
	private String options;

	private int position;

	private String shortcode;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Assignment
	@OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Assignment> assignments;

	// bi-directional many-to-one association to ExamRecord
	@OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<ExamRecord> examRecords;

	// bi-directional many-to-one association to LessonPlan
	@OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<LessonPlan> lessonPlans;

	// bi-directional many-to-one association to Note
	@OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Note> notes;

	// bi-directional many-to-one association to OnlineExam
	@OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OnlineExam> onlineExams;

	// bi-directional many-to-one association to StudentAttendance
	@OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StudentAttendance> studentAttendances;

	// bi-directional many-to-one association to SubjectTeacher
	@OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<SubjectTeacher> subjectTeachers;

	// bi-directional many-to-one association to Batch
	@ManyToOne
	private Batch batch;

	// bi-directional many-to-one association to Syllabus
	@OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Syllabus> syllabuses;

	// bi-directional many-to-one association to TimetableAllocationDetail
	@OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<TimetableAllocationDetail> timetableAllocationDetails;

}