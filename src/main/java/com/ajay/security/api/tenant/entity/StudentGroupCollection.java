package com.ajay.security.api.tenant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the student_group_collection database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_group_collection")
public class StudentGroupCollection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	// bi-directional many-to-one association to StudentGroup
	@ManyToOne
	@JoinColumn(name = "student_group_id")
	private StudentGroup studentGroup;

	// bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

}