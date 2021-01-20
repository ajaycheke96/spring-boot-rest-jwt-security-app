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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the online_exam_records database table.
 * 
 */
@Data
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
	private Timestamp createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date end;

	@Column(name = "obtained_mark", length = 10)
	private BigDecimal obtainedMark;

	@Temporal(TemporalType.TIMESTAMP)
	private Date start;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to OnlineExam
	@ManyToOne
	@JoinColumn(name = "online_exam_id")
	private OnlineExam onlineExam;

	// bi-directional many-to-one association to StudentRecord
	@ManyToOne
	@JoinColumn(name = "student_record_id")
	private StudentRecord studentRecord;

}