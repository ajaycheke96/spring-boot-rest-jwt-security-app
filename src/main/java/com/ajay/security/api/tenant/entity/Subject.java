package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the subjects database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "subjects")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 50)
	private String code;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(name = "has_no_exam")
	private byte hasNoExam;

	@Column(name = "is_elective")
	private byte isElective;

	@Column(name = "max_class_per_week")
	private int maxClassPerWeek;

	@Column(length = 50)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(length = 10)
	private int position;

	@Column(length = 50)
	private String shortcode;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Assignment
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY,orphanRemoval = true)
	private List<Assignment> assignments;

	// bi-directional many-to-one association to ExamRecord
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<ExamRecord> examRecords;

	// bi-directional many-to-one association to LessonPlan
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<LessonPlan> lessonPlans;

	// bi-directional many-to-one association to Note
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<Note> notes;

	// bi-directional many-to-one association to OnlineExam
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<OnlineExam> onlineExams;

	// bi-directional many-to-one association to StudentAttendance
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<StudentAttendance> studentAttendances;

	// bi-directional many-to-one association to SubjectTeacher
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<SubjectTeacher> subjectTeachers;

	// bi-directional many-to-one association to Batch
	@ManyToOne
	private Batch batch;

	// bi-directional many-to-one association to Syllabus
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<Syllabus> syllabuses;

	// bi-directional many-to-one association to TimetableAllocationDetail
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<TimetableAllocationDetail> timetableAllocationDetails;

}