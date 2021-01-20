package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the online_exams database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "online_exams")
public class OnlineExam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(length = 50)
	private String description;

	@Column(name = "end_time")
	private Time endTime;

	@Column(name = "exam_type", length = 50)
	private String examType;

	@Column(length = 100)
	private String instructions;

	@Column(name = "is_negative_mark_applicable")
	private byte isNegativeMarkApplicable;

	@Column(name = "is_published")
	private byte isPublished;

	@Column(name = "max_mark")
	private BigDecimal maxMark;

	@Column(length = 20)
	private String name;

	@Column(name = "negative_mark_percentage_per_question")
	private BigDecimal negativeMarkPercentagePerQuestion;

	@Column(length = 50)
	private String options;

	@Column(name = "passing_percentage")
	private BigDecimal passingPercentage;

	@Column(name = "start_time")
	private Time startTime;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to OnlineExamQuestion
	@OneToMany(mappedBy = "onlineExam", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OnlineExamQuestion> onlineExamQuestions;

	// bi-directional many-to-one association to OnlineExamRecord
	@OneToMany(mappedBy = "onlineExam", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OnlineExamRecord> onlineExamRecords;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne
	@JoinColumn(name = "academic_session_id")
	private AcademicSession academicSession;

	// bi-directional many-to-one association to Batch
	@ManyToOne
	private Batch batch;

	// bi-directional many-to-one association to Subject
	@ManyToOne
	private Subject subject;

}