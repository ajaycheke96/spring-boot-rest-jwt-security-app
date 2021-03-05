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
 * The persistent class for the student_group_collection database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_group_collection")
public class StudentGroupCollection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

//	// bi-directional many-to-one association to StudentGroup
//	@ManyToOne
//	@JoinColumn(name = "student_group_id")
//	private StudentGroup studentGroup;

	// bi-directional many-to-one association to Student
	@ManyToOne(targetEntity = Student.class)
	@JoinColumn(name = "student_id")
	@JsonIgnoreProperties({ "studentAccounts", "studentDocuments", "studentRecords", "studentParent", "user" })
	private Student student;

}