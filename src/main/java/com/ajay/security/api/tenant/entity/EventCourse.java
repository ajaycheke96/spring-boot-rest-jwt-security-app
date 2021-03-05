package com.ajay.security.api.tenant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the event_course database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "event_course")
public class EventCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	// bi-directional many-to-one association to Cours
	@ManyToOne(targetEntity = Course.class)
	@JoinColumn(name = "course_id")
	@JsonIgnoreProperties({ "academicSession", "courseGroup" })
	private Course cours;

//	// bi-directional many-to-one association to Event
//	@ManyToOne
////	@JsonIgnoreProperties("eventCourses")
//	private Event event;

}