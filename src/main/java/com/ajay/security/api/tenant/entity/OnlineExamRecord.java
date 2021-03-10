package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the online_exam_records database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "online_exam_records")
public class OnlineExamRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 100)
	private String answers;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date end;

	@Column(name = "obtained_mark", length = 10)
	private BigDecimal obtainedMark;

	@Temporal(TemporalType.TIMESTAMP)
	private Date start;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to OnlineExam
	@ManyToOne(targetEntity = OnlineExam.class)
	@JoinColumn(name = "online_exam_id")
	@JsonIgnoreProperties({ "onlineExamQuestions", "academicSession", "batch", })
	private OnlineExam onlineExam;

	// bi-directional many-to-one association to StudentRecord
	@ManyToOne
	@JoinColumn(name = "student_record_id")
	@JsonIgnoreProperties({ "certificates", "incomes", "onlineExamRecords", "studentFeeRecords", "feeAllocation",
			"admission", "transferCertificates", "transportRouteStudents" })
	private StudentRecord studentRecord;

}