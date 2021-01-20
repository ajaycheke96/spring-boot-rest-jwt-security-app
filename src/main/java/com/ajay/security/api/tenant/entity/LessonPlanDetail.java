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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the lesson_plan_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "lesson_plan_details")
public class LessonPlanDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String title;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to LessonPlan
	@ManyToOne
	@JoinColumn(name = "lesson_plan_id")
	private LessonPlan lessonPlan;

}