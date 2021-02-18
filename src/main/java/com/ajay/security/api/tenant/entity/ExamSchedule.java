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
 * The persistent class for the exam_schedules database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(name = "observation_marks", length = 50)
	private String observationMarks;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to ExamRecord
//	@OneToMany(mappedBy = "examSchedule")
//	private List<ExamRecord> examRecords;

	// bi-directional many-to-one association to Batch
	@ManyToOne(targetEntity = Batch.class)
	@JoinColumn(name = "batch_id")
	private Batch batch;

	// bi-directional many-to-one association to ExamAssessment
	@ManyToOne(targetEntity = ExamAssessment.class)
	@JoinColumn(name = "exam_assessment_id")
	private ExamAssessment examAssessment;

	// bi-directional many-to-one association to ExamGrade
	@ManyToOne(targetEntity = ExamGrade.class)
	@JoinColumn(name = "exam_grade_id")
	private ExamGrade examGrade;

	// bi-directional many-to-one association to Exam
	@ManyToOne(targetEntity = Exam.class)
	@JoinColumn(name = "exam_id")
	private Exam exam;

}