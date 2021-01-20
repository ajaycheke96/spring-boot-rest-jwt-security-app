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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the exam_schedules database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "exam_schedules")
public class ExamSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(name = "observation_marks",length = 50)
	private String observationMarks;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to ExamRecord
	@OneToMany(mappedBy = "examSchedule",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<ExamRecord> examRecords;

	// bi-directional many-to-one association to Batch
	@ManyToOne
	private Batch batch;

	// bi-directional many-to-one association to ExamAssessment
	@ManyToOne
	@JoinColumn(name = "exam_assessment_id")
	private ExamAssessment examAssessment;

	// bi-directional many-to-one association to ExamGrade
	@ManyToOne
	@JoinColumn(name = "exam_grade_id")
	private ExamGrade examGrade;

	// bi-directional many-to-one association to Exam
	@ManyToOne
	private Exam exam;

}